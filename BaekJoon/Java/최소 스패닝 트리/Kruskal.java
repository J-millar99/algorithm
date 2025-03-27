import java.io.*;
import java.util.*;

public class Kruskal {

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
            parent = new int[size];
            rank = new int[size];

            // 초기화 : 각 노드를 독립된 집합으로 설정 (자기 자신을 부모로 정해두고 시작)
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        // x의 부모를 찾는 연산
        public int find(int x) {
            if (parent[x] != x) // 매개변수로 전달받은 x가 parent[param]의 부모가 아니라면 find
                parent[x] = find(parent[x]);
            return parent[x];
        }

        // rank를 기준으로 union
        public boolean union(int x, int y) {
            int rx = find(x); // x의 부모 탐색
            int ry = find(y); // y의 부모 탐색

            if (rx == ry) // 부모가 동일하면 같은 집합에 속한 것이므로 종료
                return false;
            
            // rank를 기준으로 rank가 낮은 트리를 높은 rank 트리에 붙임
            if (rank[rx] < rank[ry])
                parent[rx] = ry;
            else if (rank[rx] > rank[ry])
                parent[ry] = rx;
            else {  // 두 rank가 동일하면 임의로 붙임
                parent[ry] = rx;
                rank[rx]++;
            }
            return true;
        }
    }

    // n개의 정점과 m개의 간선을 입력받는 예제
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        // 크기 입력
        String[] in = br.readLine().split(" ");

        // 파싱
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);

        // 간선 정보 입력
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            in = br.readLine().split(" ");
            int src, dest, weight;
            src = Integer.parseInt(in[0]);
            dest = Integer.parseInt(in[1]);
            weight = Integer.parseInt(in[2]);
            edges.add(new Edge(src, dest, weight));
        }
        // 간선을 가중치 기준으로 정렬
        Collections.sort(edges);

        // Union-Find 객체 생성
        UF uf = new UF(n);

        List<Edge> mst = new ArrayList<>();
        for (Edge edge : edges) {
            if (uf.union(edge.src, edge.dest))
                mst.add(edge);
        }
        
        for (Edge edge : mst) {
            System.out.println("정점 : " + edge.src + " - 정점 : " + edge.dest);
            System.out.println("가중치 : " + edge.weight);
        }
        br.close();
    }
}
