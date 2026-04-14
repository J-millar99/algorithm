import java.io.*;
import java.util.*;
import java.util.PriorityQueue;

public class Main {
    private static class Edge implements Comparable<Edge> {
        int destinaton;
        long weight;
        public Edge(int destinaton, long weight) {
            this.destinaton = destinaton;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.weight, o.weight);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 분기점과 경로의 수
        int n, m;
        String[] in = br.readLine().split(" ");
        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);

        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        boolean[] detect = new boolean[n];
        int idx = 0;
        in = br.readLine().split(" ");
        for (String b : in) {
            if (b.charAt(0) == '1')
                detect[idx] = true;
            idx++;
        }

        // a <-> b 양방향 간선 소요시간 t
        int a, b, t;
        for (int i = 0; i < m; i++) {
            in = br.readLine().split(" ");
            a = Integer.parseInt(in[0]);
            b = Integer.parseInt(in[1]);
            t = Integer.parseInt(in[2]);

            if ((a != n - 1 && detect[a] == true) || (b != n - 1 && detect[b] == true)) 
                continue;
            

            graph.get(a).add(new Edge(b, t));
            graph.get(b).add(new Edge(a, t));
        }
        br.close();

        long[] distances = new long[n];
        distances[0] = 0;
        Arrays.fill(distances, Long.MAX_VALUE);
        dijkstra(distances, graph, 0);

        if (distances[n - 1] == Long.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(distances[n - 1]);
    }

    public static void dijkstra(long[] distances, List<List<Edge>> graph, int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        pq.add(new Edge(start, 0));

        while(!pq.isEmpty()) {
            Edge currentEdge = pq.poll();
            int currentVertex = currentEdge.destinaton;
            long currentDistance = currentEdge.weight;

            if (currentDistance > distances[currentVertex])
                continue;

            for (Edge neighbor : graph.get(currentVertex)) {
                long newDistance = currentDistance + neighbor.weight;

                if (newDistance < distances[neighbor.destinaton]) {
                    distances[neighbor.destinaton] = newDistance;
                    pq.add(new Edge(neighbor.destinaton, newDistance));
                }
            }
        }
    }
}
