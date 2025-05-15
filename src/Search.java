import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public abstract class Search<V> {
    protected Map<Vertex<V>, Boolean> marked;
    protected Map<Vertex<V>, Vertex<V>> edgeTo;
    protected Vertex<V> start;

    public Search(Vertex<V> start) {
        this.start = start;
        this.marked = new HashMap<>();
        this.edgeTo = new HashMap<>();
    }

    public boolean hasPathTo(Vertex<V> v) {
        return marked.getOrDefault(v, false);
    }

    public Iterable<Vertex<V>> pathTo(Vertex<V> v) {
        if (!hasPathTo(v)) return null;
        LinkedList<Vertex<V>> path = new LinkedList<>();
        for (Vertex<V> x = v; x != start; x = edgeTo.get(x)) {
            path.addFirst(x);
        }
        path.addFirst(start);
        return path;
    }
}
