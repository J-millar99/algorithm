import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    static int[] parent, rank;

    static int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    static boolean union(int a, int b) {
        int ra = find(a); int rb = find(b);

        if (ra == rb)   return false;

        if (rank[ra] < rank[rb]) {
            int tmp = ra;
            ra = rb;
            rb = tmp;
        }

        parent[rb] = ra;
        if (rank[ra] == rank[rb]) rank[ra]++;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String[] in = br.readLine().split(" ");

            int n = Integer.parseInt(in[0]);
            int m = Integer.parseInt(in[1]);
            if (n + m == 0) {
                br.close();
                break;
            }

            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
            rank = new int[n];

            int[][] edges = new int[m][3];
            List<int[]> mst = new ArrayList<>();
            int maxCost = 0;
            for (int i = 0; i < m; i++) {
                in = br.readLine().split(" ");

                edges[i][0] = Integer.parseInt(in[0]);
                edges[i][1] = Integer.parseInt(in[1]);
                edges[i][2] = Integer.parseInt(in[2]);
                maxCost += edges[i][2];
            }

            Arrays.sort(edges, Comparator.comparingInt(e -> e[2]));

            int minCost = 0;
            for (int[] edge : edges) {
                if (union(edge[0], edge[1])) {
                    mst.add(edge);
                    minCost += edge[2];
                    if (mst.size() == n - 1) break;
                }
            }
            sb.append(maxCost - minCost).append("\n");
        }
        System.out.print(sb);
    }
}
