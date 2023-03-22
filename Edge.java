

public class Edge {

    public final Node to;
    public final double weight;

    /**
     * 
     * @param to
     * @param distance
     * @param speed
     */
    public Edge(Node to, int distance, double speed) {
        this.to = to;
        this.weight = distance/speed*60.0;
    }


}
