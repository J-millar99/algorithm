import java.io.*;
import java.util.*;

public class Main {
    static class Pos {
        int x, y, step;
        Pos(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }
    static int[][] d = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}
                        , {1, -2}, {2, -1}, {2, 1}, {1, 2}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tries = Integer.parseInt(br.readLine());

        for (int i = 0; i < tries; i++) {
            int size = Integer.parseInt(br.readLine());
            int[][] graph = new int[size][size];
            boolean[][] visit = new boolean[size][size];
            String in[] = br.readLine().split(" ");
            Pos start_pos = new Pos(Integer.parseInt(in[0]), Integer.parseInt(in[1]), 0);

            in = br.readLine().split(" ");
            Pos end_pos = new Pos(Integer.parseInt(in[0]), Integer.parseInt(in[1]), 0);

            sb.append(solution(size, graph, visit, start_pos, end_pos)).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    public static int solution(int size, int[][] graph, boolean[][] visit, Pos sp, Pos ep){
        Queue<Pos> q = new ArrayDeque<>();
        q.add(sp);
        while(!q.isEmpty()) {
            Pos pos = q.poll();
            if (pos.x < 0 || pos.x >= size || pos.y < 0 || pos.y >= size
            || visit[pos.x][pos.y] == true)
                continue;
            if (pos.x == ep.x && pos.y == ep.y)
                return pos.step;
            visit[pos.x][pos.y] = true;

            for (int k = 0; k < 8; k++) {
                int dx = pos.x + d[k][0];
                int dy = pos.y + d[k][1];
                q.add(new Pos(dx, dy, pos.step + 1));
            }
        }
        return -1; // 도달할 수 없는 경우 : 문제에서는 요구하지 않음
    }
}