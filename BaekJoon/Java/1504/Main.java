import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static List<List<Edge>> graph;

    // 그래프의 간선 정보를 저장하는 내부 클래스
    private static class Edge implements Comparable<Edge> {
        int destination;
        int weight;

        Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    public static int dijkstra(int start, int end) {
        // 최단 거리를 저장할 배열 (무한대로 초기화)
        int[] distances = new int[graph.size() + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;
        
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge currentEdge = pq.poll();
            int currentVertex = currentEdge.destination;
            int currentDistance = currentEdge.weight;

            // 이미 더 짧은 경로를 찾은 경우 스킵
            if (currentDistance > distances[currentVertex])
                continue;

            // 현재 정점의 모든 인접 정점 탐색
            for (Edge neighbor : graph.get(currentVertex)) {
                int newDistance = currentDistance + neighbor.weight;

                // 더 짧은 경로 발견 시 업데이트
                if (newDistance < distances[neighbor.destination]) {
                    distances[neighbor.destination] = newDistance;
                    pq.offer(new Edge(neighbor.destination, newDistance));
                }
            }
        }
        return distances[end];
    }
    
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) { // 인덱스 1번부터 사용하기 위함
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            in = br.readLine().split(" ");
            int start, end, weight;
            start = Integer.parseInt(in[0]);
            end = Integer.parseInt(in[1]);
            weight = Integer.parseInt(in[2]);

            graph.get(start).add(new Edge(end, weight));
            graph.get(end).add(new Edge(start, weight));
        }

        int v1, v2;
        in = br.readLine().split(" ");
        v1 = Integer.parseInt(in[0]);
        v2 = Integer.parseInt(in[1]);

        int first1 = dijkstra(1, v1);
        int last1 = dijkstra(v2, n);
        int essential = dijkstra(v1, v2);
        int first2 = dijkstra(1, v2);
        int last2 = dijkstra(v1, n);

        int case1 = 0, case2 = 0;
        if (first1 == Integer.MAX_VALUE || essential == Integer.MAX_VALUE || last1 == Integer.MAX_VALUE)
            case1 = -1;
        else
            case1 = first1 + essential + last1;
        
        if (first2 == Integer.MAX_VALUE || essential == Integer.MAX_VALUE || last2 == Integer.MAX_VALUE)
            case2 = -1;
        else
            case2 = first2 + essential + last2;

        if (case1 == -1 && case2 == -1)
            System.out.println("-1");
        else if (case1 == -1)
            System.out.println(case2);
        else if (case2 == -1)
            System.out.println(case1);
        else
            System.out.println(Math.min(case1, case2));
        br.close();
    }
}