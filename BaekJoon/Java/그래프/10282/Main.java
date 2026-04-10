import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    static class Edge implements Comparable<Edge> {
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
        StringBuilder sb = new StringBuilder();

        int tries = Integer.parseInt(br.readLine());
        for (int i = 0; i < tries; i++) {
            String[] in = br.readLine().split(" ");
            // 컴퓨터 개수, 의존성 개수, 해킹당한 컴퓨터의 번호
            int n, d, c;
            n = Integer.parseInt(in[0]);
            d = Integer.parseInt(in[1]);
            c = Integer.parseInt(in[2]) - 1;

            List<List<Edge>> graph = new ArrayList<>();
            for (int j = 0; j < n; j++) graph.add(new ArrayList<>());

            for (int j = 0; j < d; j++) {
                in = br.readLine().split(" ");
                int a, b, s;
                a = Integer.parseInt(in[0]) - 1;
                b = Integer.parseInt(in[1]) - 1;
                s = Integer.parseInt(in[2]);

                graph.get(b).add(new Edge(a, s));
            }

            int[] distances = dijkstra(graph, c, n);
            int infested = 0;
            int totalTime = 0;
            for (int j = 0; j < n; j++) {
                if (distances[j] == Integer.MAX_VALUE) continue;
                infested++;
                totalTime = Math.max(totalTime, distances[j]);
            }

            sb.append(infested + " " + totalTime).append("\n");
        }
        br.close();
        System.out.print(sb);
    }

    static int[] dijkstra(List<List<Edge>> graph, int start, int size) {
        int[] distances = new int[size];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        while(!pq.isEmpty()) {
            Edge current = pq.poll();
            int currentVertex = current.destination;
            int currentDistance = current.weight;

            if (currentDistance > distances[currentVertex]) continue;

            for (Edge edge : graph.get(currentVertex)) {
                int newDistance = currentDistance + edge.weight;

                if (newDistance < distances[edge.destination]) {
                    distances[edge.destination] = newDistance;
                    pq.offer(new Edge(edge.destination, newDistance));
                }
            }
        }
        return distances;
    }
}
