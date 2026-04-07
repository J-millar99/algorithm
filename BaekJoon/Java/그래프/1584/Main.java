import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static int[][] grid = new int[501][501];
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};

    private static class Edge implements Comparable<Edge> {
        int r, c, weight;

        public Edge(int r, int c, int weight) {
            this.r = r;
            this.c = c;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String in;
        String[] ins;

        in = br.readLine();
        int dangerZone = Integer.parseInt(in);

        for (int i = 0; i < dangerZone; i++) {
            ins = br.readLine().split(" ");
            int x1, y1, x2, y2;

            x1 = Integer.parseInt(ins[0]);
            y1 = Integer.parseInt(ins[1]);
            x2 = Integer.parseInt(ins[2]);
            y2 = Integer.parseInt(ins[3]);

            int min_x = Math.min(x1, x2);
            int max_x = Math.max(x1, x2);
            int min_y = Math.min(y1, y2);
            int max_y = Math.max(y1, y2);
            for (int j = min_x; j <= max_x; j++) {
                for (int k = min_y; k <= max_y; k++) {
                    grid[j][k] = 1;
                }
            }
        }

        in = br.readLine();
        int deathZone = Integer.parseInt(in);

        for (int i = 0; i < deathZone; i++) {
            ins = br.readLine().split(" ");
            int x1, y1, x2, y2;

            x1 = Integer.parseInt(ins[0]);
            y1 = Integer.parseInt(ins[1]);
            x2 = Integer.parseInt(ins[2]);
            y2 = Integer.parseInt(ins[3]);

            int min_x = Math.min(x1, x2);
            int max_x = Math.max(x1, x2);
            int min_y = Math.min(y1, y2);
            int max_y = Math.max(y1, y2);
            for (int j = min_x; j <= max_x; j++) {
                for (int k = min_y; k <= max_y; k++) {
                    grid[j][k] = -1;
                }
            }
        }
        grid[0][0] = 0;
        br.close();
        int[][] dist = dijkstra();
        if (dist[500][500] == Integer.MAX_VALUE)
            dist[500][500] = -1;
        System.out.println(dist[500][500]);
    }
    
    public static int[][] dijkstra() {
        int[][] dist = new int[501][501];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = grid[0][0];

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(0, 0, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();

            int row = current.r;
            int col = current.c;

            if (current.weight > dist[row][col])
                continue;

            for (int i = 0; i < 4; i++) {
                int dx = row + dr[i];
                int dy = col + dc[i];

                if (dx < 0 || dy < 0 || dx > 500 || dy > 500 || grid[dx][dy] == -1) continue;

                int newDistance = dist[row][col] + grid[dx][dy];

                if (newDistance < dist[dx][dy]) {
                    dist[dx][dy] = newDistance;
                    pq.offer(new Edge(dx, dy, newDistance));
                }
            }
        }
        return dist;
    }
}
