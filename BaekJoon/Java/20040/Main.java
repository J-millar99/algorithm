import java.io.*;
import java.util.*;

public class Main {
    static int[] parent, rank;

    static int find(int x) {
        if (x != parent[x])
            parent[x] = find(parent[x]);
        return parent[x];
    }

    static boolean union(int a, int b) {
        int ra = find(a); int rb = find(b);
        if (ra == rb) // 사이클
            return false;
        if (rank[ra] < rank[rb]) {
            int temp = ra;
            ra = rb;
            rb = temp;
        }
        parent[rb] = ra;

        if (rank[ra] == rank[rb])
            rank[ra]++;
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);

        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        rank = new int[n];
        
        int count = 0;
        for (int i = 1; i <= m; i++) {
            in = br.readLine().split(" ");

            int a = Integer.parseInt(in[0]);
            int b = Integer.parseInt(in[1]);
            if (!union(a, b)) {
                count = i;
                break;
            }
        }
        System.out.println(count);
        br.close();
    }
}
