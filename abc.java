package dijkstra_test;

import java.util.*;

public class Dijkstra {
    
    public static void main(String[] args) {
        // Create the graph
        Map<String, Node> graph = new HashMap<>();
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Parking p1 = new Parking("P1", 50, 40, 12);
        Parking p2 = new Parking("P2", 50, 40, 12);
        
        
        graph.put(a.id, a);
        graph.put(b.id, b);
        graph.put(c.id, c);
        graph.put(d.id, d);
        graph.put(e.id, e);
        graph.put(p1.id, p1);
        graph.put(p2.id, p2);
        a.addEdge(b, 4);
        a.addEdge(c, 2);
        b.addEdge(c, 1);
        b.addEdge(d, 5);
        c.addEdge(d, 8);
        c.addEdge(e, 10);
        d.addEdge(e, 2);
        d.addEdge(p1, 3);
        a.addEdge(p2, 4);
        
        // Run Dijkstra's algorithm starting from node 
        Node startNode = c;
        
        dijkstra(startNode, graph);
        
        // Print the shortest paths
        for (Node node : graph.values()) {
            System.out.println("Shortest path from "+ startNode.id +" to " + node.id + ": " + node.minDistance);
        }
        
        
        
        for (Node node : graph.values()) {
            if (node instanceof Parking) {
            	System.out.println("Parking");
                System.out.println("Shortest path from "+ startNode.id +" to " + node.id + ": " + node.minDistance);
            }
        }
    }
    
    public static void dijkstra(Node start, Map<String, Node> graph) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        start.minDistance = 0;
        pq.offer(start);
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            for (Edge edge : node.edges) {
                Node neighbor = edge.to;
                int distance = node.minDistance + edge.weight;
                if (distance < neighbor.minDistance) {
                    pq.remove(neighbor);
                    neighbor.minDistance = distance;
                    neighbor.previous = node;
                    pq.offer(neighbor);
                }
            }
        }
    }

    
    public static class Node implements Comparable<Node> {
        public final String id;
        public List<Edge> edges;
        public int minDistance;
        public Node previous;
        
        public Node(String id) {
            this.id = id;
            this.edges = new ArrayList<>();
            this.minDistance = Integer.MAX_VALUE;
        }
        
        public void addEdge(Node to, int weight) {
            edges.add(new Edge(to, weight));
            to.edges.add(new Edge(this, weight)); // add edge in both directions
        }
        
        public int compareTo(Node other) {
            return Integer.compare(minDistance, other.minDistance);
        }
    }
    
    public static class Parking extends Node {
        public int capacity;
        public int occupancy;
        public int flux;
        
        public Parking(String id, int capacity, int occupancy, int flux) {
            super(id);
            this.capacity = capacity;
            this.occupancy = occupancy;
            this.flux = flux;
        }
    	
    }
    
    public static class Edge {
        public final Node to;
        public final int weight;
        
        public Edge(Node to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    
}
