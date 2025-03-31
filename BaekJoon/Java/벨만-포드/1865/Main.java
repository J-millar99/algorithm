import java.util.*;
import java.io.*;

public class Main {

    static long[] distance;
    public static boolean bellmanFord(int n, List<int[]> edges) {
        distance = new long[n + 1];
        Arrays.fill(distance, 5000001);
        distance[0] = 0;

        for (int i = 1; i <= n; i++) {
            edges.add(new int[]{0, i, 0});
        }

        for (int i = 0; i < n; i++) {
            for (int[] e : edges) {
                long newDistance = distance[e[0]] + e[2];
                if (distance[e[0]] != 5000001
                    && newDistance < distance[e[1]]) {
                        distance[e[1]] = newDistance;
                    }
            }
        }

        for (int[] e : edges) {
            if (distance[e[0]] != 5000001 
                && distance[e[0]] + e[2] < distance[e[1]])
                return false;
        }
        return true;
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int tries = Integer.parseInt(br.readLine());
        for (int i = 0; i < tries; i++) {
            String[] in = br.readLine().split(" ");

            int n = Integer.parseInt(in[0]);
            int m = Integer.parseInt(in[1]);
            int warm = Integer.parseInt(in[2]);
            List<int[]> graph = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                in = br.readLine().split(" ");
                int start, end, weight;
                start = Integer.parseInt(in[0]);
                end = Integer.parseInt(in[1]);
                weight = Integer.parseInt(in[2]);
                graph.add(new int[]{start, end, weight});
                graph.add(new int[]{end, start, weight});
            }

            for (int j = 0; j < warm; j++) {
                in = br.readLine().split(" ");
                int start, end, weight;
                start = Integer.parseInt(in[0]);
                end = Integer.parseInt(in[1]);
                weight = Integer.parseInt(in[2]);
                graph.add(new int[]{start, end, -weight});
            }

            String result = bellmanFord(n, graph) ? "NO" : "YES";
            sb.append(result).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}
