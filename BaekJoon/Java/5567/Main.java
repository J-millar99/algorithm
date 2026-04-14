import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int count = 0;
    
    static class Pair {
        int value, depth;
        Pair(int value, int depth) {
            this.value = value;
            this.depth = depth;
        }
    }

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
        System.out.println(count);
        br.close();
    }

    public static void bfs(int[][] graph, boolean[] visit) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(1, 0));
        visit[1] = true;
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            int node = pair.value;
            int depth = pair.depth;
            if (depth == 2)
                continue;
            for (int i = 1; i < visit.length; i++) {
                if (graph[node][i] == 1 && visit[i] == false) {
                    q.add(new Pair(i, depth + 1));
                    visit[i] = true;
                    count++;
                }
            }
        }
    }
}
