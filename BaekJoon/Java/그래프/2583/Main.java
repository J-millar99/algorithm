import java.io.*;
import java.util.*;

public class Main {
    static int row, col, k;
    static List<Integer> areas = new ArrayList<>();
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
        k = Integer.parseInt(input[2]); // 직사각형 개수

        int[][] graph = new int[row][col];
        for (int i = 0; i < k; i++) {
            input = br.readLine().split(" ");
            int x1 = Integer.parseInt(input[1]), y1 = Integer.parseInt(input[0]);
            int x2 = Integer.parseInt(input[3]), y2 = Integer.parseInt(input[2]);
            for (int x = x1; x < x2; x++)
                for (int y = y1; y < y2; y++)
                    graph[x][y] = 1;
        }
        solution(graph);
        br.close();
    }

    public static void solution(int[][] graph) {
        StringBuilder sb = new StringBuilder();
        boolean[][] visit = new boolean[row][col];
        int count = 0; // 영역 개수 산출
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++) {
                if (visit[i][j] == true || graph[i][j] == 1)
                    continue;
                // if (bfs(i, j, graph, visit) == true)
                //     ++count;
                dfs_area = 0;
                if (dfs(i, j, graph, visit) == true) {
                    ++count;
                    areas.add(dfs_area);
                }
            }
        areas.sort(null);

        sb.append(count).append("\n");
        for (Integer area : areas)
            sb.append(area).append(" ");
        System.out.println(sb);
    }

    public static boolean bfs(int i, int j, int[][] graph, boolean[][] visit) {
        int area = 0;
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(i, j));
        while(!q.isEmpty()) {
            Pair pair = q.poll();
            if (pair.x < 0 || pair.x >= row || pair.y < 0 || pair.y >= col
            || visit[pair.x][pair.y] == true || graph[pair.x][pair.y] == 1)
                continue;
            visit[pair.x][pair.y] = true;
            area++;
            for (int k = 0; k < 4; k++) {
                int dx = pair.x + d[k][0];
                int dy = pair.y + d[k][1];
                q.add(new Pair(dx, dy));
            }
        }
        areas.add(area); // 영역 넓이 저장
        return true; // 영역 개수 산출
    }

    public static boolean dfs(int i, int j, int[][] graph, boolean[][] visit) {
        if (i < 0 || i >= row || j < 0 || j >= col
        || visit[i][j] == true || graph[i][j] == 1)
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