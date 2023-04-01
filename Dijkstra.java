import java.util.*;


public class Dijkstra {

	protected Node start;
	protected Map<String, Node> graph = new HashMap<>();
	protected ArrayList<String> OrderdArrayListBestPath;
	protected boolean aggressive;
	protected double minDistanceBestPath;

	/**
	 * 
	 * @param graph
	 * @param start_id
	 * @param aggressive - deux option, soit aggressive(true), choisir le parking le plus proche sans prendre compte du flux ou de l'occupation (tenter sa chance),
	 peut-être quelqu'un quittera la seconde que l'utilisateur se rend au parking, ou pas aggressive (false), qui prend en compte le flux afin de déterminer s'il est probable, avec le flux du moment donné, de se rendre au parking avant qu'il se remplisse.
	 */
	public Dijkstra (Map<String, Node> graph, String start_id, boolean aggressive) {
		
		this.graph = graph;

		//Trouver le node de début en référençant le id donné par l'utilisateur.
		for (Node node : graph.values()) {
			if (node.id.equals(start_id)) {
				this.start = node;
				break;
			}
		}

		this.aggressive = aggressive;

		//Excecute l'algorithme de Dijkstra.
		getShortestPathsToParking();
	}


	/**
	 * Main algorithm
	 */
	protected void getShortestPathsToParking () {
		ArrayList<Parking> shortestPathsToParking = new ArrayList<>(); // Créer un ArrayList qui store les chemins les moins longs pour ce rendre au parking.
		PriorityQueue<Node> pq = new PriorityQueue<>();	// Initialise un priority queue avec les nodes à considérer.
		Map<String, ArrayList<String>> paths = new HashMap<>(); // Créer une map pour storer toutes les routes de chaque node. Créer le graphe virtuellement.
		
		// Storer toutes les routes dans le arrayList paths.
		for (String id : graph.keySet()) {
			ArrayList<String> init = new ArrayList<>();
			// init.add(start.id);

			paths.put(id, init);
		}

		// Mettre le node de départ dans le primary queue et mettre sa distance à 0. 
		start.minDistance = 0;
		pq.offer(start);
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			
		/* Pour tous les routes liés au node qu'on examine, voir s'il a un chemin pour se rendre plus rapidement à chacun de ses voisins.
		Par exemple, si A->B = 5, A->D = 1, D->B = 2, l'algorithme va premièrement considérer que se rendre à B prend 5u et se rendre à D prend 1u.
		Cependant, il se rendra ensuite, dans le primary queue, à analyser D. Il va trouver qu'aller de D à B prend 2u. Il va alors trouver que 2u+1u<5u.
		Le minDistance pour se rendre à B sera alors changé de 5u à 3u, en passant par D (neigbor.previous).*/
		

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
		
		// Generer des chemins pour chaque destination.
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

		// Seulement considérer les nodes qui sont des parking.
		for (Node node : graph.values()) {
			if (node instanceof Parking) {
				shortestPathsToParking.add((Parking) node);
			}
		}

		// double shortestPath = Integer.MAX_VALUE;
		Node closestParking = null;

		// Comparer les parking par leur distance (temps) pour se rendre et les trier.
		Collections.sort(shortestPathsToParking, new Comparator<Parking>() {
			@Override
			public int compare(Parking node1, Parking node2) {
				return Double.compare(node1.minDistance, node2.minDistance);
			}
		});
		
		
		// Si l'algorithme n'est pas mis en mode aggressif, filtrer pour trouver les parkings voulu selon le flux et l'occupation.
		if (!aggressive) {
			ArrayList<Parking> filterd = new ArrayList<Parking>();
			for (Parking parking : shortestPathsToParking) {
			// Verifier si l'utilisateur a le temps de se rendre au parking avant qu'il se remplisse. Flux donné par heure et ensuite divisé par 60.
				if (((parking.flux * parking.minDistance / 60) + parking.occupancy) < parking.capacity) {
					filterd.add(parking);
				}
			}
			shortestPathsToParking = filterd;
		}

		// Trouver le parking le plus rapide à se rendre.
		if (!shortestPathsToParking.isEmpty()) {
			closestParking = shortestPathsToParking.get(0);

			// Variables Set et Get.
			this.minDistanceBestPath = closestParking.minDistance;
			this.OrderdArrayListBestPath = paths.get(closestParking.id);
		}

	}

	/**
	 * 
	 * @return Le temps pour le meilleur chemin. 0.0 si il ne trouve pas de chemin
	 */
	public double getTimeBestPath() {
		return this.minDistanceBestPath;
	}

	/**
	 * 
	 * @return une ArrayList ordonnée pour montrer le trajet optimal. null s'il n'y a pas de trajet possible vers un stationnement innoccupé.
	 */
	public ArrayList<String> getDirectionBestPaths() {
		return this.OrderdArrayListBestPath;
	}

}
