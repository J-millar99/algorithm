import java.io.*;
import java.util.*;
import java.util.PriorityQueue;

public class Main {
    static class Node implements Comparable<Node> {
        int r, c, weight;

        public Node(int r, int c, int weight) {
            this.r = r;
            this.c = c;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = 1;

        int tries = 1;
        StringBuilder sb = new StringBuilder();
        while (true) {
            size = Integer.parseInt(br.readLine());
            if (size == 0)
                break;
            int[][] grid = new int[size][size];

            for (int i = 0; i < size; i++) {
                String[] in = br.readLine().split(" ");
                for (int j = 0; j < size; j++) {
                    grid[i][j] = Integer.parseInt(in[j]);
                }
            }
            int[][] dist = dijkstra(grid);
            sb.append("Problem " + tries + ": " + dist[size - 1][size - 1]).append("\n");
            tries++;
        }
        System.out.print(sb);
    }

    public static int[][] dijkstra(int[][] grid) {
        int n = grid.length;
        int[][] dist = new int[n][n];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        // 시작점 (0,0)
        dist[0][0] = grid[0][0];
        pq.offer(new Node(0, 0, grid[0][0]));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            int r = current.r;
            int c = current.c;

            if (current.weight > dist[r][c]) continue;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;

                int newWeight = dist[r][c] + grid[nr][nc];

                if (newWeight < dist[nr][nc]) {
                    dist[nr][nc] = newWeight;
                    pq.offer(new Node(nr, nc, newWeight));
                }
            }
        }

        return dist;
    }
}
