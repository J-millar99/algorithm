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

        // 도시의 개수, 도로의 개수, 거리 정보, 출발 도시 번호
        int n, m, k, x;
        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);
        k = Integer.parseInt(in[2]);
        x = Integer.parseInt(in[3]);

        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            in = br.readLine().split(" ");
            // a -> b로 이동하는 단방향 간선
            int a, b;

            a = Integer.parseInt(in[0]) - 1;
            b = Integer.parseInt(in[1]) - 1;
            graph.get(a).add(new Edge(b, 1));
        }
        br.close();
        
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);

        dijkstra(distances, graph, x - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < distances.length; i++) {
            if (distances[i] == k)
                sb.append(i + 1).append("\n");
        }
        if (sb.length() == 0)
            System.out.println(-1);
        else
            System.out.print(sb);
    }

    public static void dijkstra(int[] distances, List<List<Edge>> graph, int x) {
        distances[x] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(x, 0));

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
