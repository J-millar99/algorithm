import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.ArrayList;

public class Main {
    private static class Edge implements Comparable<Edge> {
        int destination;
        int weight;
        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");

        // 정점의 개수, 간선리스트의 간선 수
        int n, m;
        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);

        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            in = br.readLine().split(" ");
            int a, b, c;

            a = Integer.parseInt(in[0]) - 1;
            b = Integer.parseInt(in[1]) - 1;
            c = Integer.parseInt(in[2]);

            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }

        in = br.readLine().split(" ");
        int s, t;
        s = Integer.parseInt(in[0]) - 1;
        t = Integer.parseInt(in[1]) - 1;
        br.close();

        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[s] = 0;
        dijkstra(distances, graph, s);
        System.out.println(distances[t]);
    }

    public static void dijkstra(int[] distances, List<List<Edge>> graph, int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        pq.add(new Edge(start, 0));
        while (!pq.isEmpty()) {
            Edge currentEdge = pq.poll();
            int currentVertex = currentEdge.destination;
            int currentDistance = currentEdge.weight;

            if (currentDistance > distances[currentVertex])
                continue;

            for (Edge neighbor : graph.get(currentVertex)) {
                int newDistance = currentDistance + neighbor.weight;
                if (newDistance < distances[neighbor.destination]) {
                    distances[neighbor.destination] = newDistance;
                    pq.add(new Edge(neighbor.destination, newDistance));
                }
            }
        }
    }
}
