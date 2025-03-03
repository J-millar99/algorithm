import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static class Pos {
        int y, x;
        Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static BufferedReader br;
    static StringBuilder sb;
    static int m, n, k;
    static int[][] field;
    static boolean[][] visit;
    static int count;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int tries = Integer.parseInt(br.readLine());

        sb = new StringBuilder();
        for (int i = 0; i < tries; i++) {
            count = 0;
            solution();
        }
        System.out.print(sb);
        br.close();
    }

    public static void solution() throws IOException {
        String[] input = br.readLine().split(" ");

        // 입력 받기
        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);

        // 배추의 위치는 1
        field = new int[n][m];
        visit = new boolean[n][m];
        // 배추 심기
        for (int i = 0; i < k; i++) {
            input = br.readLine().split(" ");
            int x, y;
            x = Integer.parseInt(input[0]);
            y = Integer.parseInt(input[1]);
            field[y][x] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // bfs(i, j);
                if (dfs(i, j) == true)
                    ++count;
            }
        }
        sb.append(count).append("\n");
    }

    public static void bfs(int i, int j) {
        if (visit[i][j] == true || field[i][j] == 0)
            return;
        Queue<Pos> q = new ArrayDeque<>();
        q.add(new Pos(i, j));

        while (!q.isEmpty()) {
            Pos pos = q.poll();
            if (pos.y < 0 || pos.y >= n || pos.x < 0 || pos.x >= m ||
                visit[pos.y][pos.x] == true || field[pos.y][pos.x] == 0)
                continue;
            visit[pos.y][pos.x] = true;
            
            q.add(new Pos(pos.y + 1, pos.x));
            q.add(new Pos(pos.y, pos.x + 1));
            q.add(new Pos(pos.y - 1, pos.x));
            q.add(new Pos(pos.y, pos.x - 1));
        }
        ++count;
    }

    public static boolean dfs(int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= m ||
            visit[i][j] == true || field[i][j] == 0)
            return false;
        visit[i][j] = true;
        dfs(i + 1, j);
        dfs(i - 1, j);
        dfs(i, j + 1);
        dfs(i, j - 1);
        return true;
    }
}