import java.util.*;

public class BellmanFord {
    static class Edge {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    static int[] distance;
    public static boolean bellmanFord(int n, List<Edge> edges, int start) {
        distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        for (int i = 1; i < n; i++) {
            for (Edge e : edges) {
                int newDistance = distance[e.start] + e.weight;
                if (distance[e.start] != Integer.MAX_VALUE
                    && newDistance < distance[e.end]) {
                        distance[e.end] = newDistance;
                    }
            }
        }

        for (Edge e : edges) {
            if (distance[e.start] != Integer.MAX_VALUE 
                && distance[e.start] + e.weight < distance[e.end])
                return false;
        }
        return true;
    }
}
