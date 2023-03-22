import java.util.*;

public class Main {
	public static void main(String[] args) {

        Map<String, Node> graph = new HashMap<>();

		//Initiate starting intersections
		Node a = new Node("A");
		Node b = new Node("B");
		Node c = new Node("C");
		Node d = new Node("D");
		Node e = new Node("E");
		Node f = new Node("F");
		Node g = new Node("G");
		Node h = new Node("H");
		Node i = new Node("I");

		//Initiate destination parkings
		Parking p1 = new Parking("P1", 50, 0, 0);
		Parking p2 = new Parking("P2", 50, 0, 0);
		Parking p3 = new Parking("P3", 50, 0, 0);
		Parking p4 = new Parking("P4", 50, 0, 0);
	
		//Connect intersections and parking together
		a.addEdge(p1, 20,90);
		a.addEdge(p2, 20,90);
		a.addEdge(e, 3, 70);
		b.addEdge(p1, 3, 30);
		b.addEdge(e, 10, 50);
		c.addEdge(p2, 3, 30);
		c.addEdge(e, 10, 50);
		d.addEdge(p1, 3, 30);
		d.addEdge(p3, 3, 30);
		e.addEdge(g, 10, 50);
		e.addEdge(h, 10, 50);
		f.addEdge(p2, 3, 30);
		f.addEdge(p4, 3, 30);
		g.addEdge(p3, 10, 50);
		h.addEdge(p4, 10, 50);
		i.addEdge(p3, 20, 100);
		i.addEdge(p4, 20, 100);


		//Add all the Nodes to the graph
		graph.put(a.id, a);
		graph.put(b.id, b);
		graph.put(c.id, c);
		graph.put(d.id, d);
		graph.put(e.id, e);
		graph.put(f.id, f);
		graph.put(g.id, g);
		graph.put(h.id, h);
		graph.put(i.id, i);

		graph.put(p1.id, p1);
		graph.put(p2.id, p2);
		graph.put(p3.id, p3);
		graph.put(p4.id, p4);

        //Use case
        //Here the agressive parameter is false
        /*
         * Here the aggressive parameter is set to false
         * The algo will therefore take into account the capacity of the parkings
         */
		Dijkstra test1 = new Dijkstra(graph, "E", false);
		System.out.println(test1.getDirectionBestPaths());
		System.out.println(test1.getTimeBestPath());
	}
}
