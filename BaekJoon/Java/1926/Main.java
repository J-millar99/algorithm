import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");

        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);

        int[][] field = new int[n][m];
        for (int i = 0; i < n; i++) {
            in = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                field[i][j] = Integer.parseInt(in[j]);
            }
        }

        boolean[][] visited = new boolean[n][m];
        int maxSize = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == true || field[i][j] == 0)
                    continue;
                count++;
                maxSize = Math.max(maxSize, bfs(field, visited, i, j));
            }
        }
        br.close();
        System.out.println(count);
        System.out.println(maxSize);
    }

    public static int bfs(int[][] field, boolean[][] visited, int i, int j) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i, j});

        int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int size = 0;
        while (!q.isEmpty()) {
            int[] e = q.poll();
            int x = e[0];
            int y = e[1];

            if (visited[x][y] == true)
                continue;
            visited[x][y] = true;
            size++;
            
            for (int k = 0; k < 4; k++) {
                int dx = x + dir[k][0];
                int dy = y + dir[k][1];
                if (0 <= dx && dx < n && 0 <= dy && dy < m && !visited[dx][dy] && field[dx][dy] == 1) {
                    q.add(new int[]{dx, dy});
                }
            }
        }
        return size;
    }
}
