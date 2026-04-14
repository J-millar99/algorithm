import java.io.*;
import java.util.*;

public class Main {
    static int size;
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

        size = Integer.parseInt(br.readLine()); // 단지 크기
        char[][] graph = new char[size][size];
        for (int i = 0; i < size; i++) {
            String in = br.readLine();
            for (int j = 0; j < size; j++) {
                graph[i][j] = in.charAt(j);
            }
        }
        solution(graph);
        br.close();
    }

    public static void solution(char[][] graph) {
        StringBuilder sb = new StringBuilder();
        boolean[][] visit = new boolean[size][size];

        int count = 0; // 영역 개수 산출
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                if (visit[i][j] == true || graph[i][j] == '0')
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
            sb.append(area).append("\n");
        System.out.print(sb);
    }

    // public static boolean bfs(int i, int j, char[][] graph, boolean[][] visit) {
    //     int area = 0;
    //     Queue<Pair> q = new ArrayDeque<>();
    //     q.add(new Pair(i, j));
    //     while(!q.isEmpty()) {
    //         Pair pair = q.poll();
    //         if (pair.x < 0 || pair.x >= size || pair.y < 0 || pair.y >= size
    //         || visit[pair.x][pair.y] == true || graph[pair.x][pair.y] == '0')
    //             continue;
    //         visit[pair.x][pair.y] = true;
    //         area++;
    //         for (int k = 0; k < 4; k++) {
    //             int dx = pair.x + d[k][0];
    //             int dy = pair.y + d[k][1];
    //             q.add(new Pair(dx, dy));
    //         }
    //     }
    //     areas.add(area); // 단지 넓이 저장
    //     return true; // 단지 개수 산출
    // }

    public static boolean dfs(int i, int j, char[][] graph, boolean[][] visit) {
        if (i < 0 || i >= size || j < 0 || j >= size
        || visit[i][j] == true || graph[i][j] == '0')
            return false;
        visit[i][j] = true;
        dfs_area++;
        for (int k = 0; k < 4; k++) {
            int dx = i + d[k][0];
            int dy = j + d[k][1];
            dfs(dx, dy, graph, visit);
        }
        return true; // 단지 개수 산출
    }
}