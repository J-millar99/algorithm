import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    static ArrayList<Integer>[] adj;
    static int[] subtreeSize;  // 서브트리 크기 (미리 계산)
    static int[] parent;       // 각 노드의 부모 노드

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");

        int n = Integer.parseInt(in[0]);
        int r = Integer.parseInt(in[1]);
        int q = Integer.parseInt(in[2]);

        adj = new ArrayList[n + 1];
        subtreeSize = new int[n + 1];
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
            subtreeSize[i] = 1; // 자기 자신 포함하여 초기값 1
        }

        // 간선 입력
        for (int i = 0; i < n - 1; i++) {
            in = br.readLine().split(" ");
            int u = Integer.parseInt(in[0]);
            int v = Integer.parseInt(in[1]);
            adj[u].add(v);
            adj[v].add(u);
        }

        // 트리 빌드 + 서브트리 크기 계산 (반복문 방식)
        buildTreeAndCalculate(r, n);

        // 쿼리 처리: O(1) 조회
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int node = Integer.parseInt(br.readLine());
            sb.append(subtreeSize[node]).append("\n");
        }

        br.close();
        System.out.print(sb);
    }

    static void buildTreeAndCalculate(int root, int n) {
        int[] order = new int[n];
        int idx = 0;

        boolean[] visited = new boolean[n + 1];
        Stack<Integer> stack = new Stack<>();

        stack.push(root);
        visited[root] = true;
        parent[root] = 0;

        while(!stack.isEmpty()) {
            int node = stack.pop();
            order[idx++] = node;

            for (int next : adj[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    parent[next] = node;
                    stack.push(next);
                }
            }
        }

        // 맨 마지막 리프노드부터 자신의 크기를 부모의 크기에 더함
        for (int i = idx - 1; i > -1; i--) {
            int node = order[i];
            subtreeSize[parent[node]] += subtreeSize[node];
        }
    }
}