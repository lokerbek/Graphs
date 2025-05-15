import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch<V> extends Search<V> {

    public BreadthFirstSearch(WeightedGraph<V> graph, Vertex<V> start) {
        super(start);
        bfs(graph, start);
    }

    private void bfs(WeightedGraph<V> graph, Vertex<V> start) {
        Queue<Vertex<V>> queue = new LinkedList<>();
        marked.put(start, true);
        queue.add(start);

        while (!queue.isEmpty()) {
            Vertex<V> v = queue.poll();
            for (Vertex<V> w : v.getAdjacentVertices().keySet()) {
                if (!marked.containsKey(w)) {
                    marked.put(w, true);
                    edgeTo.put(w, v);
                    queue.add(w);
                }
            }
        }
    }
}
