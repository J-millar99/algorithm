import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    static int MAXINT = Integer.MAX_VALUE;

    static class Edge implements Comparable<Edge> {
        int destination;
        int weight;
        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 마을 수, 단방향 경로, 파티 위치
        int n, m, x;

        String[] in = br.readLine().split(" ");
        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);
        x = Integer.parseInt(in[2]) - 1;

        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            in = br.readLine().split(" ");
            int a, b, c;
            a = Integer.parseInt(in[0]) - 1;
            b = Integer.parseInt(in[1]) - 1;
            c = Integer.parseInt(in[2]);

            graph.get(a).add(new Edge(b, c));
        }
        br.close();

        int maxDistance = 0;
        for (int i = 0; i < n; i++) {
            if (i == x)
                continue;
            int go = dijkstra(graph, i, x, n); // i번째 집에서 x로 가는 최단 거리
            int back = dijkstra(graph, x, i, n); // x에서 i번째 집에 가는 최단 거리
            maxDistance = Math.max(go + back, maxDistance);
        }
        System.out.println(maxDistance);
    }

    static int dijkstra(List<List<Edge>> graph, int start, int end, int size) {
        int[] distances = new int[size];
        Arrays.fill(distances, MAXINT);
        distances[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        while(!pq.isEmpty()) {
            Edge current = pq.poll();
            int currentVertex = current.destination;
            int currentDistance = current.weight;

            if (currentDistance > distances[currentVertex])
                continue;

            for (Edge neighbor : graph.get(currentVertex)) {
                int newDistance = currentDistance + neighbor.weight;

                if (newDistance < distances[neighbor.destination]) {
                    distances[neighbor.destination] = newDistance;
                    pq.offer(new Edge(neighbor.destination, newDistance));
                }
            }
        }
        return distances[end];
    }
}
