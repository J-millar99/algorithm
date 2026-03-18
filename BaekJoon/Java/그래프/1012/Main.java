import java.io.*;
import java.util.*;


public class Main {

    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] dir = {
        {1, 0},
        {0 ,1},
        {-1, 0},
        {0, -1},
    };

    static int m, n, k;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tries = Integer.parseInt(br.readLine());

        for (int i = 0; i < tries; i++) {
            answer = 0;
            String[] in = br.readLine().split(" ");

            // 가로, 세로, 배추 개수
            m = Integer.parseInt(in[0]);
            n = Integer.parseInt(in[1]);
            k = Integer.parseInt(in[2]);

            // 배추 밭
            int[][] field = new int[m][n];

            // 배추의 위치 큐
            Queue<Pair> q = new ArrayDeque<>();

            for (int j = 0; j < k; j++) {
                in = br.readLine().split(" ");
                int x, y;

                // 배추의 위치
                x = Integer.parseInt(in[0]);
                y = Integer.parseInt(in[1]);

                field[x][y] = 1;
                q.add(new Pair(x, y));
            }

            // 큐에서 배추 하나의 위치를 뽑아 깊이 우선 탐색(너비 우선 탐색도 가능)
            while (!q.isEmpty()) {
                Pair e = q.poll();
                if (dfs(field, e.x, e.y))
                    answer++;
            }
            System.out.println(answer);
        }
        br.close();
    }

    public static boolean dfs(int[][] field, int row, int col) {
        // 큐에서 추출한 위치는 배추의 위치(1)이지만 깊이 우선 탐색으로 0이 되었을 경우 다음 요소를 추출 + 다음 위치가 0인 경우 까지 패스
        if (field[row][col] == 0)
            return false;
        field[row][col] = 0;
    
        for (int i = 0; i < 4; i++) {
            int dx = row + dir[i][0];
            int dy = col + dir[i][1];
            if (0 > dx || m <= dx || 0 > dy || n <= dy)
                continue;
            dfs(field, dx, dy);
        }
        return true;
    }
}