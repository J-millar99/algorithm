import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    static class Edge implements Comparable<Edge>{
        int dest;
        int weight;
        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in[] = br.readLine().split(" ");

        int V = Integer.parseInt(in[0]);
        int E = Integer.parseInt(in[1]);

        int start = Integer.parseInt(br.readLine()) - 1;

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) 
            graph.add(new ArrayList<>());
        
        for (int i = 0; i < E; i++) {
            in = br.readLine().split(" ");
            int u = Integer.parseInt(in[0]) - 1;
            int v = Integer.parseInt(in[1]) - 1;
            int w = Integer.parseInt(in[2]);
            Edge node = new Edge(v, w);
            graph.get(u).add(node);
        }
        br.close();

        int[] distances = new int[V];
        Arrays.fill(distances, Integer.MAX_VALUE);
        dijkstra(graph, start, distances);
        StringBuilder sb = new StringBuilder();
        for (int distance : distances) {
            if (distance == Integer.MAX_VALUE)
                sb.append("INF");
            else
                sb.append(distance);
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void dijkstra(List<List<Edge>> graph, int start, int[] distances) {
        distances[start] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int currentVertex = edge.dest; // 현재 노드
            int currentDistance = edge.weight; // 현재 거리

            // 갱신 불가
            if (currentDistance > distances[currentVertex])
                continue;

            for (Edge neighbor : graph.get(currentVertex)) {
                int newDistance = neighbor.weight + currentDistance;

                if (newDistance < distances[neighbor.dest]) {
                    distances[neighbor.dest] = newDistance;
                    pq.add(new Edge(neighbor.dest, newDistance));
                }
            }
        }
    }
}
