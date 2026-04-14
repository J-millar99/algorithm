import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static final int INF = 100000 * (100 - 1) + 1;
    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());
        int edges = Integer.parseInt(br.readLine());
        int[][] graph = new int[size + 1][size + 1];
        int[][] next = new int[size + 1][size + 1];
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                graph[i][j] = INF;
            }
        }

        for (int i = 1; i <= size; i++) {
            graph[i][i] = 0;
        }

        for (int i = 0; i < edges; i++) {
            String[] in = br.readLine().split(" ");
            int a, b, c;
            a = Integer.parseInt(in[0]);
            b = Integer.parseInt(in[1]);
            c = Integer.parseInt(in[2]);
            if (graph[a][b] > c)
                graph[a][b] = c;
            next[a][b] = b;
        }

        for (int k = 1; k <= size; k++) {
            for (int i = 1; i <= size; i++) {
                for (int j = 1; j <= size; j++) {
                    if (graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                if (graph[i][j] == INF)
                    graph[i][j] = 0;
            }
        }

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                if (graph[i][j] == INF)
                    sb.append("0").append(" ");
                else
                    sb.append(graph[i][j]).append(" ");
            }
            sb.append("\n");
        }

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                if (graph[i][j] == 0 || graph[i][j] == INF) {
                    sb.append("0\n");
                    continue;
                }
                List<Integer> arr = new ArrayList<>();
                int st = i;
                while (st != j) {
                    arr.add(st);
                    st = next[st][j];
                }
                arr.add(j);
                sb.append(arr.size()).append(" ");
                for (Integer integer : arr)
                    sb.append(integer).append(" ");
                sb.append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }
}
