import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    private Map<Vertex<V>, Double> distTo;

    public DijkstraSearch(WeightedGraph<V> graph, Vertex<V> start) {
        super(start);
        distTo = new HashMap<>();
        for (Vertex<V> v : graph.getVertices()) {
            distTo.put(v, Double.POSITIVE_INFINITY);
        }
        distTo.put(start, 0.0);

        PriorityQueue<Vertex<V>> pq = new PriorityQueue<>(Comparator.comparingDouble(distTo::get));
        pq.add(start);

        while (!pq.isEmpty()) {
            Vertex<V> current = pq.poll();
            marked.put(current, true);

            for (Map.Entry<Vertex<V>, Double> entry : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = entry.getKey();
                double weight = entry.getValue();
                double newDist = distTo.get(current) + weight;

                if (newDist < distTo.get(neighbor)) {
                    distTo.put(neighbor, newDist);
                    edgeTo.put(neighbor, current);
                    pq.add(neighbor);
                }
            }
        }
    }

    public double getDistance(Vertex<V> v) {
        return distTo.getOrDefault(v, Double.POSITIVE_INFINITY);
    }
}
