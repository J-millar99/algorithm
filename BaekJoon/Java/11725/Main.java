import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> tree = new ArrayList<>();
    static boolean[] visit;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int i;

        visit = new boolean[n + 1];
        parent = new int[n + 1];
        for (i = 0; i < n + 1; i++)
            tree.add(new ArrayList<>());

        for (i = 0; i < n - 1; i++) {
            String[] nodes = br.readLine().split(" ");
            int node1 = Integer.parseInt(nodes[0]);
            int node2 = Integer.parseInt(nodes[1]);
            tree.get(node1).add(node2);
            tree.get(node2).add(node1);
        }
        dfs(1, n);
        for (i = 2; i < n + 1; i++)
            System.out.println(parent[i]);
        br.close();
    }

    public static void dfs(int root, int n) {
        visit[root] = true;
        for (int node : tree.get(root)) {
            if (visit[node] == false) {
                visit[node] = true;
                parent[node] = root;
                dfs(node, n);
            }
        }
    }
}
