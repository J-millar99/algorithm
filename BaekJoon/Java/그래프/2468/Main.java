import java.io.*;
import java.util.*;

public class Main {
    static int size;
    static int[][] d = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static class Pos {
        int x, y;
        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());

        int[][] graph = new int[size][size];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            String[] in = br.readLine().split(" ");
            for (int j = 0; j < size; j++) {
                int value = Integer.parseInt(in[j]);
                graph[i][j] = value;
                set.add(value);
            }
        }
        solution(graph, set);
        br.close();
    }

    public static void solution(int[][] graph, Set<Integer> set) {
        int maxCount = 1;
        for (Integer rain_height : set) { // 장마 높이
            boolean[][] visit = new boolean[size][size];
            int count = 0; // 안전 지역 수
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (graph[i][j] <= rain_height || visit[i][j] == true)
                        continue; // 잠기거나 방문한 지역
                    // bfs(new Pos(i, j), graph, visit, rain_height);
                    if (dfs(new Pos(i, j), graph, visit, rain_height) == true)
                        count++;
                }
            }
            maxCount = Math.max(count, maxCount);
        }
        System.out.println(maxCount);
    }

    public static void bfs(Pos pos, int[][] graph, boolean[][] visit, int rain_height) {
        Queue<Pos> q = new ArrayDeque<>();
        q.add(pos);
        while (!q.isEmpty()) {
            Pos cur_pos = q.poll();
            if (cur_pos.x < 0 || cur_pos.x >= size || cur_pos.y < 0 || cur_pos.y >= size
            || visit[cur_pos.x][cur_pos.y] == true
            || graph[cur_pos.x][cur_pos.y] <= rain_height)
                continue;
            visit[cur_pos.x][cur_pos.y] = true;
            for (int i = 0; i < 4; i++) {
                int dx = cur_pos.x + d[i][0];
                int dy = cur_pos.y + d[i][1];
                q.add(new Pos(dx, dy));
            }
        }
    }

    public static boolean dfs(Pos pos, int[][] graph, boolean[][] visit, int rain_height) {
        if (pos.x < 0 || pos.x >= size || pos.y < 0 || pos.y >= size
            || visit[pos.x][pos.y] == true
            || graph[pos.x][pos.y] <= rain_height)
                return false;
        visit[pos.x][pos.y] = true;
        for (int i = 0; i < 4; i++) {
            int dx = pos.x + d[i][0];
            int dy = pos.y + d[i][1];
            dfs(new Pos(dx, dy), graph, visit, rain_height);
        }
        return true;
    }
}