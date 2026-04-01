import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[][] graph;
    static int n, m;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static int bfs() {
        Deque<int[]> dq = new ArrayDeque<>();
        int[][] dist = new int[m + 1][n + 1];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        dq.add(new int[]{1, 1});
        dist[1][1] = 0;

        while (!dq.isEmpty()) {
            int[] pos = dq.poll();
            int x = pos[0];
            int y = pos[1];
        
            if (x == m && y == n)
                return dist[m][n];
            
            for (int i = 0; i < 4; i++) {
                int dx = x + dir[i][0];
                int dy = y + dir[i][1];
                if (dx <= 0 || dx > m || dy <= 0 || dy > n) // 맵 밖은 제거
                    continue;
                int newDist = dist[x][y] + (graph[dx][dy] == '1'? 1 : 0);
                if (newDist < dist[dx][dy]) {
                    dist[dx][dy] = newDist;
                    if (graph[dx][dy] == '1')
                        dq.add(new int[]{dx, dy});
                    else
                        dq.addFirst(new int[]{dx, dy});
                }
            }
        }
        return -1;
    }
    
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);

        graph = new char[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            String input = br.readLine();
            for (int j = 1; j <= n; j++) {
                graph[i][j] = input.charAt(j - 1);
            }
        }
        System.out.println(bfs());
        br.close();
    }
}