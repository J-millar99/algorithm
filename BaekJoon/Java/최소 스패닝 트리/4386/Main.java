import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    static class Pos {
        int idx;
        double x, y;

        public Pos(int idx, double x, double y) {
            this.idx = idx;
            this.x = x;
            this.y = y;
        }
    }

    static class Edge implements Comparator<Edge>{
        int x, y;
        double distance;

        public Edge(int x, int y, double distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public int compare(Edge o1, Edge o2) {
            return Double.compare(o1.distance, o2.distance);
        }
    }

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

        int n;

        String in = br.readLine();
        n = Integer.parseInt(in);

        List<Pos> pos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] ins = br.readLine().split(" ");
            Pos point = new Pos(i, Double.parseDouble(ins[0]), Double.parseDouble(ins[1]));
            pos.add(point);
        }
        br.close();

        m = n * (n - 1);
        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            for (int j = i; j < n; j++) {
                Pos p1 = pos.get(i);
                Pos p2 = pos.get(j);
                double newDistance = Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
                edges.add(new Edge(p1.idx, p2.idx, newDistance));
            }
        }
        Collections.sort(edges, (e1, e2) -> Double.compare(e1.distance, e2.distance));
        
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
            
        rank = new int[n];
        double cost = 0;
        int mst = 0;
        for (Edge edge : edges) {
            if (union(edge.x, edge.y)) {
                mst++;
                cost += edge.distance;
                if (mst == n - 1)
                    break;
            }
        }
        double truncated = ((long)(cost * 100)) / 100.0;
        System.out.println(truncated); // 3.14
    }
}
