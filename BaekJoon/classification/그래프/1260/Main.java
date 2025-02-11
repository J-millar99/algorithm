import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static List<List<Integer>> graph;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());

        drawGraph(br, n, m);
        dfs(startNode);
        bfs(startNode);
        br.close();
    }

    public static void drawGraph(BufferedReader br, int n, int m) throws IOException {
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            StringTokenizer node = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(node.nextToken());
            int v = Integer.parseInt(node.nextToken());

            // 무방향 그래프의 양방향 연결
            graph.get(u).add(v);
            graph.get(v).add(u);

        }
        for (int i = 1; i <= n; i++)
            Collections.sort(graph.get(i));
        br.close();
    }

    public static void recursiveDfs(int node, boolean[] visit, StringBuilder sb) {
        visit[node] = true;
        sb.append(node).append(" ");
        for (int neighbor : graph.get(node))
            if (visit[neighbor] == false)
                recursiveDfs(neighbor, visit, sb);
    }

    public static void dfs(int start) {
        StringBuilder sb = new StringBuilder();
        int size = graph.size();
        boolean[] visit = new boolean[size];

        recursiveDfs(start, visit, sb);
        System.out.println(sb);
    }

    public static void bfs(int start) {
        StringBuilder sb = new StringBuilder();
        int size = graph.size();
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visit = new boolean[size];

        visit[start] = true;
        queue.offer(start);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            sb.append(node).append(" ");
            for (int neighbor : graph.get(node)) {
                if (visit[neighbor] == false) {
                    visit[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
        System.out.println(sb);
    }
}
