import java.util.*;
import java.lang.NullPointerException;

public class Dijkstra {

	public Node start;
	public Map<String, Node> graph = new HashMap<>();
	public int searchAggressiveness;

	public Dijkstra (String start_id, int searchAggressiveness) {
		//Initiate the graph
		Node a = new Node("A");
		Node b = new Node("B");
		Node c = new Node("C");
		Node d = new Node("D");
		Node e = new Node("E");
		Parking p1 = new Parking("P1", 50, 50, 2);
		Parking p2 = new Parking("P2", 50, 50, -12);
		Parking p3 = new Parking("P3", 50, 50, 2);
		Parking p4 = new Parking("P4", 50, 50, 1);
		graph.put(a.id, a);
		graph.put(b.id, b);
		graph.put(c.id, c);
		graph.put(d.id, d);
		graph.put(e.id, e);
		graph.put(p1.id, p1);
		graph.put(p2.id, p2);
		graph.put(p3.id, p3);
		graph.put(p4.id, p4);
		a.addEdge(b, 4,50);
		a.addEdge(c, 2,50);
		b.addEdge(c, 1,50);
		b.addEdge(d, 5,50);
		c.addEdge(d, 8,50);
		// c.addEdge(e, 10,50);
		d.addEdge(e, 2,50);
		e.addEdge(c, 2,50);
		c.addEdge(p1, 2,50);

		// e.addEdge(p1, 3,50);
		a.addEdge(p2, 4,50);
		c.addEdge(p3, 1,50);
		c.addEdge(p4, 3,50);

		for (Node node : graph.values()) {
			if (node.id.equals(start_id)) {
				this.start = node;
				break;
			}
		}

		this.searchAggressiveness = searchAggressiveness;
	}

	public void getShortestPathsToParking () {
		ArrayList<Node>	shortestPathsToParking = new ArrayList<>();
		ArrayList<String> temp = new ArrayList<>();
		PriorityQueue<Node> pq = new PriorityQueue<>();
		Map<String, ArrayList<String>> paths = new HashMap<>();
		
		// Store the paths to each node in the graph
		for (String id : graph.keySet()) {
			paths.put(id, new ArrayList<>());
		}

		start.minDistance = 0;
		pq.offer(start);
		while (!pq.isEmpty()) {

			temp.clear();
			Node node = pq.poll();
			for (Edge edge : node.edges) {
				Node 	neighbor = edge.to;
				double 	distance = node.minDistance + edge.weight;

				if (distance < neighbor.minDistance) {
					pq.remove(neighbor);
					neighbor.minDistance = distance;
					neighbor.previous = node;
					pq.offer(neighbor);
				}

				// Add the neighbor's id to the path to the current node
				ArrayList<String> pathToNeighbor = paths.get(neighbor.id);
				pathToNeighbor.add(node.id);
				paths.put(neighbor.id, pathToNeighbor);

				if (neighbor instanceof Parking) {
					Parking parking = (Parking) neighbor;
					shortestPathsToParking.add(parking);

					int score = parking.occupancy + parking.flux;

					if (searchAggressiveness == 0) {
						if (score < parking.capacity) {
							System.out.println(parking.occupancy);	
							shortestPathsToParking.add(parking);
						}
					} else if (searchAggressiveness == 1) {
						if (parking.occupancy < parking.capacity) {
							shortestPathsToParking.add(parking);
						}
					} else {
						shortestPathsToParking.add(parking);
					}

				}
			}

		}

		// Print the paths to each node
		for (String id : paths.keySet()) {
			System.out.println("Paths to " + id + ": " + paths.get(id));
		}
		

		double shortestPath = Integer.MAX_VALUE;
		Node closestParking = null;

		for (Node node : shortestPathsToParking) {

			if (node.minDistance < shortestPath) {
				shortestPath = node.minDistance;
				closestParking = node;
			}
		}




		try {
			System.out.println("Closest parking is " + closestParking.id + ": " + shortestPath);
		} catch (NullPointerException e1) {
			searchAggressiveness = 2;
			getShortestPathsToParking();
			for (Node node : shortestPathsToParking) {
				if (node.minDistance < shortestPath) {
					shortestPath = node.minDistance;
					closestParking = node;
				}
			}

			System.out.println("No parkings are available. The closest parking that is full is " + closestParking.id
					+ " with a distance of " + shortestPath);
		}


		for (Node node : graph.values()) {
			if (node instanceof Parking) {
				System.out.println("Parking");
				System.out.println("Shortest path from " + start.id + " to " + node.id + ": " + paths.get(node.id));
			}
		}

	}

	public double getDistanceShortestPathsToParking() {
		return 1.0;
	}

	public ArrayList<String> getDirectionShortestPath() {
		return new ArrayList<>();
	}

	public static void main(String[] args) {
		Dijkstra test1 = new Dijkstra("C", 2);
		test1.getShortestPathsToParking();

		// Dijkstra test2 = new Dijkstra("A", 0);
		// test2.getShortestPathsToParking();

	}

}
