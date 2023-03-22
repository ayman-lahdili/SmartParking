import java.util.*;

public class Node implements Comparable<Node>{
    
    public final String id;
    public List<Edge> edges;
    public double minDistance;
    public Node previous;

    /**
     * 
     * @param id
     */
    public Node(String id) {
        this.id = id;
        this.edges = new ArrayList<>();
        this.minDistance = Integer.MAX_VALUE;
    }

    public void addEdge(Node to, int distance, int speed) {
        edges.add(new Edge(to, distance, speed));
        to.edges.add(new Edge(this, distance, speed)); // add edge in both directions
    }

    public int compareTo(Node other) {
        return Double.compare(minDistance, other.minDistance);
    }
    
}
