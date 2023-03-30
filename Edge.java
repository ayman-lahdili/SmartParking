/* Cette classe sert à créer une route du point (Node ou parking) A au point B. Il prend en paramètre to, le point B, la distance de la route et la vitesse de la route. */

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
