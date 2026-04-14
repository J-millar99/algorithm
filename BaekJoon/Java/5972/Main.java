import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    private static class Edge implements Comparable<Edge> {
        int destinaton;
        int weight;
        public Edge(int destinaton, int weight) {
            this.destinaton = destinaton;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 헛간의 개수와 소들의 길 개수
        int n, m;
        String[] in = br.readLine().split(" ");
        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);

        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // a <-> b 양방향 간선, 소의 마리수
        int a, b, c;
        for (int i = 0; i < m; i++) {
            in = br.readLine().split(" ");
            a = Integer.parseInt(in[0]) - 1;
            b = Integer.parseInt(in[1]) - 1;
            c = Integer.parseInt(in[2]);

            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }
        br.close();

        int[] distances = new int[n];
        distances[0] = 0;
        Arrays.fill(distances, Integer.MAX_VALUE);
        dijkstra(distances, graph, 0);

        System.out.println(distances[n - 1]);
    }

    public static void dijkstra(int[] distances, List<List<Edge>> graph, int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        pq.add(new Edge(start, 0));

        while(!pq.isEmpty()) {
            Edge currentEdge = pq.poll();
            int currentVertex = currentEdge.destinaton;
            int currentDistance = currentEdge.weight;

            if (currentDistance > distances[currentVertex])
                continue;

            for (Edge neighbor : graph.get(currentVertex)) {
                int newDistance = currentDistance + neighbor.weight;

                if (newDistance < distances[neighbor.destinaton]) {
                    distances[neighbor.destinaton] = newDistance;
                    pq.add(new Edge(neighbor.destinaton, newDistance));
                }
            }
        }
    }
}
