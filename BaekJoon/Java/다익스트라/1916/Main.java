import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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

    public static int[] dijkstra(List<List<Edge>> graph, int start) {
        int vertices = graph.size();

        // 최단 거리를 저장할 배열 (무한대로 초기화)
        int[] distances = new int[vertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));


        // 최단 경로 추적을 위한 이전 노드 배열
        int[] previous = new int[vertices];
        Arrays.fill(previous, -1);

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
                    previous[neighbor.destination] = currentVertex;
                    pq.offer(new Edge(neighbor.destination, newDistance));
                }
            }
        }
        return distances;
    }
    
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            String[] in = br.readLine().split(" ");
            int start, end, weight;
            start = Integer.parseInt(in[0]);
            end = Integer.parseInt(in[1]);
            weight = Integer.parseInt(in[2]);

            graph.get(start - 1).add(new Edge(end - 1, weight));
        }

        String[] in = br.readLine().split(" ");
        int start, end;
        start = Integer.parseInt(in[0]);
        end = Integer.parseInt(in[1]);
        int[] distances = dijkstra(graph, start - 1);
        System.out.println(distances[end - 1]);
        br.close();
    }
}