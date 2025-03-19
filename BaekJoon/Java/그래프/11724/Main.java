import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int count = 0;
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);

        boolean[] visit = new boolean[n + 1];
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            in = br.readLine().split(" ");
            int node1 = Integer.parseInt(in[0]);
            int node2 = Integer.parseInt(in[1]);
            graph[node1][node2] = graph[node2][node1] = 1;
        }

        for (int i = 1; i < visit.length; i++) {
            if (visit[i] == false && dfs(graph, visit, i) == true)
                count++;
        }

        // for (int i = 1; i < visit.length; i++) {
        //     if (visit[i] == false) {
        //         bfs(graph, visit, i);
        //         count++;
        //     }
        // }

        System.out.println(count);
        br.close();
    }

    public static boolean dfs(int[][] graph, boolean[] visit, int start) {
        visit[start] = true; // 시작 노드 방문처리
        for (int i = 1; i < visit.length; i++) {
            if (graph[start][i] == 1 && visit[i] == false)
                dfs(graph, visit, i);
        }
        return true;
    }

    public static void bfs(int[][] graph, boolean[] visit, int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visit[start] = true;
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int i = 1; i < visit.length; i++) {
                if (graph[node][i] == 1 && visit[i] == false) {
                    q.add(i);
                    visit[i] = true;
                }
            }
        }
    }
}