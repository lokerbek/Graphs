import java.util.HashSet;
import java.util.Set;

public class WeightedGraph<V> {
    private Set<Vertex<V>> vertices;

    public WeightedGraph() {
        this.vertices = new HashSet<>();
    }

    public void addVertex(Vertex<V> vertex) {
        vertices.add(vertex);
    }

    public void addEdge(Vertex<V> source, Vertex<V> destination, double weight) {
        if (!vertices.contains(source)) addVertex(source);
        if (!vertices.contains(destination)) addVertex(destination);
        source.addAdjacentVertex(destination, weight);
    }

    public Set<Vertex<V>> getVertices() {
        return vertices;
    }
}
