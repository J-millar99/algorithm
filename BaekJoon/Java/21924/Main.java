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

        if (ra == rb) return false;

        if (rank[ra] < rank[rb]) {
            int tmp = ra;
            ra = rb;
            rb = tmp;
        }
        parent[rb] = ra;
        if (rank[ra] == rank[rb])   rank[ra]++;
        return true;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n, m;

        String[] in = br.readLine().split(" ");
        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);

        int[][] edges = new int[m][3];
        long totalCost = 0;
        for (int i = 0; i < m; i++) {
            in = br.readLine().split(" ");

            edges[i][0] = Integer.parseInt(in[0]) - 1;
            edges[i][1] = Integer.parseInt(in[1]) - 1;
            edges[i][2] = Integer.parseInt(in[2]);
            totalCost += edges[i][2];
        }
        br.close();

        Arrays.sort(edges, Comparator.comparingInt(e -> e[2]));
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        rank = new int[n];
        List<int[]> mst = new ArrayList<>();
        long cost = 0;
        for (int[] edge : edges) {
            if (union(edge[0], edge[1])) {
                mst.add(edge);
                cost += edge[2];
                if (mst.size() == n - 1)
                    break;
            }
        }
        if (mst.size() != n - 1)
            System.out.println(-1);
        else
            System.out.println(totalCost - cost);
    }
}
