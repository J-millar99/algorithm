import java.io.*;
import java.util.*;

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

        int N = Integer.parseInt(in[0]); // 지름길 개수
        int D = Integer.parseInt(in[1]); // 고속도로 길이

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= D; i++) {
            graph.add(new ArrayList<>());
        }

        // ✅ 기본 도로 간선 추가 (i → i+1, 가중치 1)
        for (int i = 0; i < D; i++) {
            graph.get(i).add(new Edge(i + 1, 1));
        }

        for (int i = 0; i < N; i++) {
            in = br.readLine().split(" ");
            int start  = Integer.parseInt(in[0]);
            int end    = Integer.parseInt(in[1]);
            int length = Integer.parseInt(in[2]);

            // 유효하지 않은 지름길 필터링
            if (end > D || end - start <= length)
                continue;

            graph.get(start).add(new Edge(end, length));
        }
        br.close();

        int[] distances = new int[D + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);

        dijkstra(distances, graph, 0);

        System.out.println(distances[D]);
    }

    public static void dijkstra(int[] distances, List<List<Edge>> graph, int start) {
        distances[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge currentEdge = pq.poll();
            int currentVertex   = currentEdge.destination;
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