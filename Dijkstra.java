import java.util.*;


public class Dijkstra {

	protected Node start;
	protected Map<String, Node> graph = new HashMap<>();
	protected boolean aggressive;
	protected double minDistanceBestPath;
	protected ArrayList<String> OrdererdArrayListBestPath;

	/**
	 * 
	 * @param graph
	 * @param start_id
	 * @param aggressive
	 */
	public Dijkstra (Map<String, Node> graph, String start_id, boolean aggressive) {
		
		this.graph = graph;

		//Finds which Node is referenced
		for (Node node : graph.values()) {
			if (node.id.equals(start_id)) {
				this.start = node;
				break;
			}
		}

		this.aggressive = aggressive;

		//Excecute Dijkstra algorithm 
		getShortestPathsToParking();
	}


	/**
	 * Main algorithm
	 */
	protected void getShortestPathsToParking () {
		ArrayList<Parking>	shortestPathsToParking = new ArrayList<>();
		ArrayList<String> temp = new ArrayList<>();
		PriorityQueue<Node> pq = new PriorityQueue<>();
		Map<String, ArrayList<String>> paths = new HashMap<>();
		
		// Store the paths to each node in the graph
		for (String id : graph.keySet()) {
			ArrayList<String> init = new ArrayList<>();
			// init.add(start.id);

			paths.put(id, init);
		}

		// Main Loop for the algo
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
			}
		}
		
		//Generate the paths for each destination
		for (String id : paths.keySet()) {
			Node node =  graph.get(id);
			
			ArrayList<String> init = paths.get(id);

			Node prev = node.previous;
			while (prev != null) {
				init.add(0, prev.id);

				prev = prev.previous;
			}
			init.add(id);
			paths.put(id, init);
		}


		System.out.println(paths);


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
		

		if (!aggressive) {
			ArrayList<Parking> filterd = new ArrayList<Parking>();
			for (Parking parking : shortestPathsToParking) {
			// Verify if by the time I arrive to the parking is still going to have place
				if (((parking.flux * parking.minDistance / 60) + parking.occupancy) < parking.capacity) {
					filterd.add(parking);
				}
			}
			shortestPathsToParking = filterd;
		}

		// Find the shortest path
		if (!shortestPathsToParking.isEmpty()) {
			closestParking = shortestPathsToParking.get(0);

			// Set Getter Variables
			this.minDistanceBestPath = closestParking.minDistance;
			this.OrdererdArrayListBestPath = paths.get(closestParking.id);
		}

	}

	/**
	 * 
	 * @return 
	 */
	public double getTimeBestPath() {
		return this.minDistanceBestPath;
	}

	public ArrayList<String> getDirectionBestPaths() {
		return this.OrdererdArrayListBestPath;
	}

}
