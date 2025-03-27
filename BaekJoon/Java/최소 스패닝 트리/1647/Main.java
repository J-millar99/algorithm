import java.io.*;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }

    }

    static class UF {
        int[] parent;
        int[] rank;

        public UF(int size) {
            parent = new int[size + 1];
            rank = new int[size + 1];

            for (int i = 1; i <= size; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        public boolean union(int x, int y) {
            int rx = find(x);
            int ry = find(y);

            if (rx == ry)
                return false;
            
            if (rank[rx] < rank[ry])
                parent[rx] = ry;
            else if (rank[rx] > rank[ry])
                parent[ry] = rx;
            else {
                parent[ry] = rx;
                rank[rx]++;
            }
            return true;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
            
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);
        
        List<Edge> edges = new ArrayList<>();
        for (int j = 0; j < m; j++) {
            in = br.readLine().split(" ");
            int src, dest, weight;
            src = Integer.parseInt(in[0]);
            dest = Integer.parseInt(in[1]);
            weight = Integer.parseInt(in[2]);
            edges.add(new Edge(src, dest, weight));
        }
        Collections.sort(edges);
        UF uf = new UF(n);
            
        List<Edge> mst = new ArrayList<>();
        int max = 0;
        for (Edge edge : edges) {
            if (uf.union(edge.src, edge.dest)) {
                mst.add(edge);
                max = Math.max(max, edge.weight);
            }
        }
        System.out.print(mst.stream().mapToInt(edge -> edge.weight).sum() - max);
        br.close();
    }
}
