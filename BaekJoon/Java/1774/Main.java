import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static class Pos {
        int idx;
        int x, y;
        boolean[] connected;

        public Pos(int idx, int x, int y, int size) {
            connected = new boolean[size];
            this.idx = idx;
            this.x = x;
            this.y = y;
        }
    }
    static class Edge {
        int p1, p2;
        double distance;

        public Edge(int p1, int p2, double distance) {
            this.p1 = p1;
            this.p2 = p2;
            this.distance = distance;
        }
    }
    static int[] parent, rank;
    static int find(int x) {
        if (x != parent[x])
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
        String[] in = br.readLine().split(" ");

        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);
        
        List<Pos> pos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            in = br.readLine().split(" ");
            int x = Integer.parseInt(in[0]);
            int y = Integer.parseInt(in[1]);
            pos.add(new Pos(i, x, y, n)); // node 번호, (x, y)좌표, size
        }

        // a, b는 번호 x, y는 좌표
        for (int i = 0; i < m; i++) {
            in = br.readLine().split(" ");
            int a = Integer.parseInt(in[0]) - 1;
            int b = Integer.parseInt(in[1]) - 1;
            pos.get(a).connected[b] = true;
            pos.get(b).connected[a] = true;
        }
        br.close();
        List<Edge> graph = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                Pos p1 = pos.get(i);
                Pos p2 = pos.get(j);

                double distance = Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
                if (p1.connected[p2.idx] || p2.connected[p1.idx])
                    distance = 0;
                graph.add(new Edge(p1.idx, p2.idx, distance));
            }
        }

        Collections.sort(graph, (e1, e2) -> Double.compare(e1.distance, e2.distance));
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        rank = new int[n];
        int mst = 0;
        double cost = 0;
        for (Edge edge : graph) {
            if (union(edge.p1, edge.p2)) {
                mst++;
                cost += edge.distance;
                if (mst == n - 1) break;
            }
        }
        System.out.println(String.format("%.2f", cost));
    }
}
