import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    private static class Edge implements Comparable<Edge> {
        int destination;
        int weight;
        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
        @Override
        public int compareTo(Main.Edge o) {
            return this.weight - o.weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] in = br.readLine().split(" ");
        
        // 지역 수, 수색 범위, 길 수
        int n, m, r;

        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);
        r = Integer.parseInt(in[2]);

        in = br.readLine().split(" ");
        int[] items = new int[n];
        for (int i = 0; i < n; i++) {
            items[i] = Integer.parseInt(in[i]);
        }

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < r; i++) {
            in = br.readLine().split(" ");

            int a, b, c;
            a = Integer.parseInt(in[0]) - 1;
            b = Integer.parseInt(in[1]) - 1;
            c = Integer.parseInt(in[2]);

            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }
        br.close();
        int maxItemCount = 0;
        for (int i = 0; i < n; i++) {
            int[] dist = dijkstra(graph, i);
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (dist[j] <= m) {
                    sum += items[j];
                }
            }
            maxItemCount = Math.max(maxItemCount, sum);
        }
        System.out.println(maxItemCount);
    }

    private static int[] dijkstra(List<List<Edge>> graph, int start) {
        int size = graph.size();
        int[] dist = new int[size];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        while(!pq.isEmpty()) {
            Edge currentEdge = pq.poll();
            int currentVertex = currentEdge.destination;
            int currentDistance = currentEdge.weight;

            if (currentDistance > dist[currentVertex]) continue;

            for (Edge neighbor : graph.get(currentVertex)) {
                int newDistance = neighbor.weight + currentDistance;

                if (newDistance < dist[neighbor.destination]) {
                    dist[neighbor.destination] = newDistance;
                    pq.offer(new Edge(neighbor.destination, newDistance));
                }
            }
        }
        return dist;
    }
}
