/* Cette classe sert à créer une route du point (Node ou parking) A au point B. Il prend en paramètre to, le point B, la distance de la route et la vitesse de la route. */

public class Edge {

    public final Node to;   // La route est crée du node A to node B. to designe B.
    public final double weight; // Le weight s'agit du temps nécessaire pour conduire la route du début jusqu'à la fin.

    /**
     * 
     * @param to
     * @param distance
     * @param speed
     */
    public Edge(Node to, int distance, double speed) {
        this.to = to;
        this.weight = distance/speed*60.0; // Le temps est calculé avec la distance(km)/vitesse(km/h)*60min/h pour nous donner le temps en minutes.
    }


}
