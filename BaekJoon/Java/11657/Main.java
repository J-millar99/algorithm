import java.util.*;
import java.io.*;

public class Main {
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

    static long[] distance;
    public static boolean bellmanFord(int n, List<Edge> edges, int start) {
        distance = new long[n + 1];
        Arrays.fill(distance, 5000001);
        distance[start] = 0;

        for (int i = 1; i < n; i++) {
            for (Edge e : edges) {
                long newDistance = distance[e.start] + e.weight;
                if (distance[e.start] != 5000001
                    && newDistance < distance[e.end]) {
                        distance[e.end] = newDistance;
                    }
            }
        }

        for (Edge e : edges) {
            if (distance[e.start] != 5000001 
                && distance[e.start] + e.weight < distance[e.end])
                return false;
        }
        return true;
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");

        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);
        List<Edge> graph = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            in = br.readLine().split(" ");
            int start, end, weight;
            start = Integer.parseInt(in[0]);
            end = Integer.parseInt(in[1]);
            weight = Integer.parseInt(in[2]);
            graph.add(new Edge(start, end, weight));
        }
        if (bellmanFord(n, graph, 1) == false)
            sb.append("-1\n");
        else {
            for (int i = 2; i <= n; i++) {
                long d = distance[i];
                if (d == 5000001)
                    sb.append("-1\n");
                else
                    sb.append(d).append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }
}
