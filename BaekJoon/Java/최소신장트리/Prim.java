import java.io.*;
import java.util.*;

class PrimMST {
    // 간선 정보를 저장하는 내부 클래스
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

    // 프림 알고리즘을 사용한 최소 신장 트리 찾기
    public static List<int[]> primMST(List<List<Edge>> graph) {
        int vertices = graph.size();
        
        // 최소 신장 트리에 포함될 간선들을 저장할 리스트
        List<int[]> mst = new ArrayList<>();
        
        // 방문 여부를 추적하는 배열
        boolean[] visited = new boolean[vertices];
        
        // 최소 힙을 사용하여 최소 가중치 간선 선택
        PriorityQueue<Edge> minHeap = new PriorityQueue<>();
        
        // 시작 정점 0번을 초기 선택
        minHeap.offer(new Edge(0, 0));
        
        // 총 가중치 추적
        int totalWeight = 0;
        while (!minHeap.isEmpty()) {
            Edge currentEdge = minHeap.poll();
            int currentVertex = currentEdge.destination;
            
            // 이미 방문한 정점은 건너뜀
            if (visited[currentVertex]) continue;
            
            // 정점 방문 표시
            visited[currentVertex] = true;
            
            // 시작 정점이 아닌 경우 최소 신장 트리에 간선 추가
            if (currentEdge.weight != 0) {
                mst.add(new int[]{
                    findParentVertex(graph, visited, currentVertex), 
                    currentVertex, 
                    currentEdge.weight
                });
                totalWeight += currentEdge.weight;
            }
            
            // 현재 정점의 인접 간선 탐색
            for (Edge neighborEdge : graph.get(currentVertex)) {
                if (!visited[neighborEdge.destination]) {
                    minHeap.offer(neighborEdge);
                }
            }
        }
        
        // 모든 정점을 방문하지 못한 경우 (비연결 그래프)
        if (mst.size() != vertices - 1) {
            throw new IllegalArgumentException("그래프가 연결되어 있지 않습니다.");
        }
        
        return mst;
    }
    
    // 부모 정점을 찾는 보조 메서드
    private static int findParentVertex(List<List<Edge>> graph, boolean[] visited, int currentVertex) {
        for (int i = 0; i < graph.size(); i++) {
            if (visited[i]) {
                for (Edge edge : graph.get(i)) {
                    if (edge.destination == currentVertex) {
                        return i;
                    }
                }
            }
        }
        return -1; // 시작 정점의 경우
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 // n개의 정점과 m개의 간선을 입력받는 예제
    public static void main(String[] args) throws IOException {
        // 크기 입력
        String[] in = br.readLine().split(" ");

        // 파싱
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);

        // 인접 리스트로 그래프 표현
        List<List<Edge>> graph = new ArrayList<>();

        // 6개의 정점에 대한 인접 리스트 초기화
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보 입력
        for (int i = 0; i < m; i++) {
            in = br.readLine().split(" ");
            int src, dest, weight;
            src = Integer.parseInt(in[0]);
            dest = Integer.parseInt(in[1]);
            weight = Integer.parseInt(in[2]);
            addEdge(graph, src, dest, weight);
        }
        
        // 최소 신장 트리 계산
        List<int[]> mst = primMST(graph);
        
        // 최소 신장 트리 간선 출력
        System.out.println("최소 신장 트리 간선:");
        for (int[] edge : mst) {
            System.out.printf("정점 %d - 정점 %d (가중치: %d)\n", 
                              edge[0], edge[1], edge[2]);
        }
    }
    
    // 무방향 그래프의 간선 추가 메서드
    private static void addEdge(List<List<Edge>> graph, int src, int dest, int weight) {
        graph.get(src).add(new Edge(dest, weight));
        graph.get(dest).add(new Edge(src, weight));
    }
}