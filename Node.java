import java.util.*;

public class Node implements Comparable<Node>{
    
    public final String id; 
    public List<Edge> edges;    // Liste avec tous les routes connectés au node.
    public double minDistance;  // Distance minimale du node de départ à celui-ci.
    public Node previous;   // Reference le node que l'algorithme de plus petit chemin a prit avant de se rendre à celui-ci.

    /**
     * 
     * @param id
     */
    public Node(String id) {
        this.id = id;
        this.edges = new ArrayList<>(); // Initialise la liste edges comme un nouveau ArrayList.
        this.minDistance = Integer.MAX_VALUE;   // Initialise la distance minimale du node de départ au node présent au maximum (Puisqu'on a pas encore déterminé un chemin.)
    }

    public void addEdge(Node to, int distance, int speed) {
        edges.add(new Edge(to, distance, speed));   // Ajouter une route du node A au node B.
        to.edges.add(new Edge(this, distance, speed)); // Ajouter la même route, mais du node B au node A.
    }

    //  Compare la distance minimale du node de départ à ce node avec la distance minimale du node de départ à un autre node.
    
    public int compareTo(Node other) {
        return Double.compare(minDistance, other.minDistance);  //  retourne un int négatif si plus proche du node de départ, zero si égale et positif si plus loin.
    }
    
}
