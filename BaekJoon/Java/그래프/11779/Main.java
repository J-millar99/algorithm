import java.io.*;
import java.util.*;

public class Main {
    static int[] distances;
    static int[] previous;

    static StringBuilder sb = new StringBuilder();
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
        int n, m;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        String[] in;
        for (int j = 0; j < m; j++) {
            in = br.readLine().split(" ");
            int s, e, c;
            s = Integer.parseInt(in[0]);
            e = Integer.parseInt(in[1]);
            c = Integer.parseInt(in[2]);
            graph.get(s).add(new Edge(e, c));
        }

        in = br.readLine().split(" ");
        int start, end;
        start = Integer.parseInt(in[0]);
        end = Integer.parseInt(in[1]);
        br.close();

        dijkstra(graph, start, end, n + 1);
        printShortestPath(start, end);
    }

    static void dijkstra(List<List<Edge>> graph, int start, int end, int size) {
        distances = new int[size];
        previous = new int[size];
        Arrays.fill(previous, -1);
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
                    previous[edge.destination] = currentVertex;
                    pq.offer(new Edge(edge.destination, newDistance));
                }
            }
        }
        sb.append(distances[end]).append("\n");
    }

    static void printShortestPath(int start, int end) {
        List<Integer> path = new ArrayList<>();
        for (int at = end; at != -1; at = previous[at]) path.add(at);
        Collections.reverse(path);
        sb.append(path.size()).append("\n");
        for (Integer node : path) {
            sb.append(node).append(" ");
        }
        System.out.println(sb);
    }
}
