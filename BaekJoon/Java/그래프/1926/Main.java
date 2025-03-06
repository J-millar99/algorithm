import java.io.*;
import java.util.*;

public class Main {
    static int row, col;
    static int max_area = 0;
    static int dfs_area;
    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[][] d = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        row = Integer.parseInt(input[0]);
        col = Integer.parseInt(input[1]);

        int[][] graph = new int[row][col];
        for (int i = 0; i < row; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < col; j++) {
                graph[i][j] = Integer.parseInt(input[j]);
            }
        }
        solution(graph);
        br.close();
    }

    public static void solution(int[][] graph) {
        boolean[][] visit = new boolean[row][col];
        int count = 0; // 영역 개수 산출
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++) {
                if (visit[i][j] == true || graph[i][j] == 0)
                    continue;
                // if (bfs(i, j, graph, visit) == true)
                //     ++count;
                dfs_area = 0;
                if (dfs(i, j, graph, visit) == true) {
                    ++count;
                    max_area = Math.max(dfs_area, max_area);
                }
            }
        System.out.println(count);
        System.out.println(max_area);
    }

    public static boolean bfs(int i, int j, int[][] graph, boolean[][] visit) {
        int area = 0;
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(i, j));
        while(!q.isEmpty()) {
            Pair pair = q.poll();
            if (pair.x < 0 || pair.x >= row || pair.y < 0 || pair.y >= col
            || visit[pair.x][pair.y] == true || graph[pair.x][pair.y] == 0)
                continue;
            visit[pair.x][pair.y] = true;
            area++;
            for (int k = 0; k < 4; k++) {
                int dx = pair.x + d[k][0];
                int dy = pair.y + d[k][1];
                q.add(new Pair(dx, dy));
            }
        }
        max_area = Math.max(max_area, area); // 최대 넓이 산출
        return true; // 영역 개수 산출
    }

    public static boolean dfs(int i, int j, int[][] graph, boolean[][] visit) {
        if (i < 0 || i >= row || j < 0 || j >= col
        || visit[i][j] == true || graph[i][j] == 0)
            return false;
        visit[i][j] = true;
        dfs_area++;
        for (int k = 0; k < 4; k++) {
            int dx = i + d[k][0];
            int dy = j + d[k][1];
            dfs(dx, dy, graph, visit);
        }
        return true; // 영역 개수 산출
    }
}