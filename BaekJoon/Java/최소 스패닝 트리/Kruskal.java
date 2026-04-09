import java.util.*;

public class Kruskal {

    static int[] parent, rank;

    // 루트 노드 찾기 (경로 압축)
    static int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    // 두 집합 합치기 (union by rank)
    static boolean union(int a, int b) {
        int ra = find(a), rb = find(b);
        if (ra == rb) return false; // 같은 집합 → 사이클 발생
        if (rank[ra] < rank[rb]) { int tmp = ra; ra = rb; rb = tmp; }
        parent[rb] = ra;
        if (rank[ra] == rank[rb]) rank[ra]++;
        return true;
    }

    public static void main(String[] args) {
        int V = 5; // 정점 수
        // {가중치, 정점A, 정점B}
        int[][] edges = {
            {1, 0, 1}, {3, 0, 2}, {2, 1, 2},
            {4, 1, 3}, {5, 2, 3}, {6, 3, 4}
        };

        // 간선을 가중치 기준 오름차순 정렬
        Arrays.sort(edges, Comparator.comparingInt(e -> e[0]));

        parent = new int[V];
        rank   = new int[V];
        for (int i = 0; i < V; i++) parent[i] = i;

        int totalCost = 0;
        List<int[]> mst = new ArrayList<>();

        for (int[] edge : edges) {
            int cost = edge[0], u = edge[1], v = edge[2];
            if (union(u, v)) {          // 사이클 없으면 선택
                mst.add(edge);
                totalCost += cost;
                if (mst.size() == V - 1) break; // MST 완성
            }
        }

        System.out.println("=== Kruskal MST ===");
        mst.forEach(e -> System.out.printf("  %d - %d (가중치: %d)%n", e[1], e[2], e[0]));
        System.out.println("  총 비용: " + totalCost);
    }
}