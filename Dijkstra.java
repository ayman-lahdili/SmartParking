import java.util.*;

public class Dijkstra {

	public Node start;
	public Map<String, Node> graph = new HashMap<>();
	public boolean aggressive;
	public double minDistanceBestPath;
	public ArrayList<String> OrdererdArrayListBestPath;

	public Dijkstra (String start_id, boolean aggressive) {
		//Initiate the graph
		Node a = new Node("A");
		Node b = new Node("B");
		Node c = new Node("C");
		Node d = new Node("D");
		Node e = new Node("E");
		Parking p1 = new Parking("P1", 50, 40, 1);
		Parking p2 = new Parking("P2", 50, 51, 1);
		graph.put(a.id, a);
		graph.put(b.id, b);
		graph.put(c.id, c);
		graph.put(d.id, d);
		graph.put(e.id, e);
		graph.put(p1.id, p1);
		graph.put(p2.id, p2);
		a.addEdge(b, 1,1);
		a.addEdge(c, 1,1);
		a.addEdge(e, 1, 1);
		b.addEdge(d, 1, 1);
		b.addEdge(p1, 5, 1);
		c.addEdge(d, 2, 1);
		c.addEdge(p2, 7, 1);
		d.addEdge(p1, 2, 1);
		d.addEdge(p2, 1, 1);
		e.addEdge(p2, 1, 1);


		for (Node node : graph.values()) {
			if (node.id.equals(start_id)) {
				this.start = node;
				break;
			}
		}

		this.aggressive = aggressive;
		getShortestPathsToParking();
	}

	public void getShortestPathsToParking () {
		ArrayList<Parking>	shortestPathsToParking = new ArrayList<>();
		ArrayList<String> temp = new ArrayList<>();
		PriorityQueue<Node> pq = new PriorityQueue<>();
		Map<String, ArrayList<String>> paths = new HashMap<>();
		
		// Store the paths to each node in the graph
		for (String id : graph.keySet()) {
			ArrayList<String> init = new ArrayList<>();
			init.add(start.id);

			paths.put(id, init);
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

					// Add the neighbor's id to the path to the current node
					ArrayList<String> pathToNeighbor = paths.get(neighbor.id);
					pathToNeighbor.add(node.id);
					paths.put(neighbor.id, pathToNeighbor);
				}
	
			}

		}

		//Add only the parkings to the array that will be processed
		for (Node node : graph.values()) {
			if (node instanceof Parking) {
				shortestPathsToParking.add((Parking) node);
			}
		}

		// double shortestPath = Integer.MAX_VALUE;
		Node closestParking = null;

		// Sort in ascending order by taking into account minDistance of each Parking
		Collections.sort(shortestPathsToParking, new Comparator<Parking>() {
			@Override
			public int compare(Parking node1, Parking node2) {
				return Double.compare(node1.minDistance, node2.minDistance);
			}
		});
		
		ArrayList<Parking> filterd = new ArrayList<Parking>();

		for (Parking parking : shortestPathsToParking) {
			if (!aggressive) {
				// Verify if by the time I arrive to the parking is still going to have place
				if (((parking.flux * parking.minDistance / 60) + parking.occupancy) < parking.capacity) {
					filterd.add(parking);
				}
			}

			if (aggressive) {
				// Verify if by the time I arrive to the parking is still going to have place
				filterd.add(parking);
			}
		}
		shortestPathsToParking = filterd;


		// find the shortest path
		if (!shortestPathsToParking.isEmpty()) {
			closestParking = shortestPathsToParking.get(0);
			this.minDistanceBestPath = closestParking.minDistance;
			this.OrdererdArrayListBestPath = paths.get(closestParking.id);
		}

		//	Adds the destination at the end of the ArrayList
		//	To make the processing easier 
		for (String id : paths.keySet()) {
			ArrayList<String> init = paths.get(id);
			init.add(id);
			paths.put(id, init);
		}
	}

	public double getDistanceBestPath() {
		return this.minDistanceBestPath;
	}

	public ArrayList<String> getDirectionBestPaths() {
		return this.OrdererdArrayListBestPath;
	}

	public static void main(String[] args) {
		Dijkstra test1 = new Dijkstra("A", false);
		System.out.println(test1.getDirectionBestPaths());
		System.out.println(test1.getDistanceBestPath());
	}

}
