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

    static boolean union(int a, int b){
        int ra = find(a); int rb = find(b);
        if(ra == rb)    return false;

        if (rank[ra] < rank[rb]) {
            int temp = ra;
            ra = rb;
            rb = temp;
        }

        parent[rb] = ra;

        if(rank[ra] == rank[rb])    rank[ra]++;

        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");

        int V, E;

        V = Integer.parseInt(in[0]);
        E = Integer.parseInt(in[1]);

        parent = new int[V];
        for (int i = 0; i < V; i++) parent[i] = i;
        rank = new int[V];

        int[][] edges = new int[E][3];
        for (int i = 0; i < E; i++) {
            in = br.readLine().split(" ");

            edges[i][0]  = Integer.parseInt(in[0]) - 1;
            edges[i][1]  = Integer.parseInt(in[1]) - 1;
            edges[i][2]  = Integer.parseInt(in[2]);
        }
        br.close();
        Arrays.sort(edges, Comparator.comparingInt(e -> e[2]));

        List<int[]> mst = new ArrayList<>();
        int totalCost = 0;
        for (int[] edge : edges) {
            if (union(edge[0], edge[1])) {
                mst.add(edge);
                totalCost += edge[2];
                if (mst.size() == V - 1) break;
            }
        }

        System.out.println(totalCost);
    }
}
