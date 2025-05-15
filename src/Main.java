public class Main {
    public static void main(String[] args) {
        Vertex<String> a = new Vertex<>("A");
        Vertex<String> b = new Vertex<>("B");
        Vertex<String> c = new Vertex<>("C");
        Vertex<String> d = new Vertex<>("D");
        Vertex<String> e = new Vertex<>("E");

        WeightedGraph<String> graph = new WeightedGraph<>();
        graph.addEdge(a, b, 4);
        graph.addEdge(a, c, 2);
        graph.addEdge(b, c, 5);
        graph.addEdge(b, d, 10);
        graph.addEdge(c, e, 3);
        graph.addEdge(e, d, 4);
        graph.addEdge(d, a, 7);

        System.out.println("--- BFS ---");
        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(graph, a);
        for (Vertex<String> v : graph.getVertices()) {
            if (bfs.hasPathTo(v)) {
                System.out.print("Path to " + v + ": ");
                for (Vertex<String> step : bfs.pathTo(v)) {
                    System.out.print(step + " ");
                }
                System.out.println();
            }
        }

        System.out.println("\n--- Dijkstra ---");
        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(graph, a);
        for (Vertex<String> v : graph.getVertices()) {
            if (dijkstra.hasPathTo(v)) {
                System.out.print("Path to " + v + " (Distance: " + dijkstra.getDistance(v) + "): ");
                for (Vertex<String> step : dijkstra.pathTo(v)) {
                    System.out.print(step + " ");
                }
                System.out.println();
            }
        }
    }
}
