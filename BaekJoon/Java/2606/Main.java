import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int count = 0;
    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int[][] graph = new int[num + 1][num + 1];
        boolean[] visit = new boolean[num + 1];
        for (int i = 0; i < n; i++) {
            String[] in = br.readLine().split(" ");
            int node1 = Integer.parseInt(in[0]);
            int node2 = Integer.parseInt(in[1]);
            graph[node1][node2] = 1;
            graph[node2][node1] = 1;
        }
        // bfs(graph, visit);
        dfs(graph, visit, 1);
        System.out.println(count);
        br.close();
    }

    // public static void bfs(int[][] graph, boolean[] visit) {
    //     Queue<Integer> q = new ArrayDeque<>();
    //     q.add(1); // 노드 1번부터 시작
    //     visit[1] = true;
    //     while (!q.isEmpty()) {
    //         int node = q.poll();
    //         for (int i = 1; i < visit.length; i++) {
    //             if (graph[node][i] == 1 && visit[i] == false) {
    //                 q.add(i);
    //                 visit[i] = true;
    //                 count++;
    //             }
    //         }
    //     }
    // }

    public static void dfs(int[][] graph, boolean[] visit, int start) {
        visit[start] = true; // 시작 노드 방문처리
        if (start != 1) // 시작 1번 노드는 개수를 세지 않아야 함.
            count++;
        for (int i = 1; i < visit.length; i++) {
            if (graph[start][i] == 1 && visit[i] == false)
                dfs(graph, visit, i);
        }
    }
}
