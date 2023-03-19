import java.util.*;
import java.lang.NullPointerException;

public class Dijkstra {

	public Node start;
	public Map<String, Node> graph = new HashMap<>();

	public Dijkstra () {
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
		c.addEdge(e, 10,50);
		d.addEdge(e, 2,50);
		d.addEdge(p1, 3,50);
		a.addEdge(p2, 4,50);
		c.addEdge(p3, 1,50);
		c.addEdge(p4, 3,50);

		this.graph = graph;
		this.start = c;
	}

	public void getShortestPathsToParking (int searchAggressiveness) {
		ArrayList<Node> shortestPathsToParking  = new ArrayList<>();
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		start.minDistance = 0;
		
		pq.offer(start);

		while (!pq.isEmpty()) {
			Node node = pq.poll();
			for (Edge edge : node.edges) {
				Node neighbor = edge.to;
				double distance = node.minDistance + edge.weight;
				if (distance < neighbor.minDistance) {
					pq.remove(neighbor);
					neighbor.minDistance = distance;
					neighbor.previous = node;
					pq.offer(neighbor);
				}
				if (neighbor instanceof Parking) {
					Parking parking = (Parking) neighbor; //Unecessary?

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
			getShortestPathsToParking(2);
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
				System.out.println("Shortest path from " + start.id + " to " + node.id + ": " + node.minDistance);
			}
		}



		// return shortestPathsToParking;
	}








	public static void main(String[] args) {
		Dijkstra algo = new Dijkstra();
		algo.getShortestPathsToParking(0);



	}

}
