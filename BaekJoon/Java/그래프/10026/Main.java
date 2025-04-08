import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());
        char[][] graph = new char[size][size];
        for (int i = 0; i < size; i++) {
            String in = br.readLine();
            for (int j = 0; j < size; j++) {
                graph[i][j] = in.charAt(j);
            }
        }

        normal(graph, size);
        protanopia(graph, size);
        br.close();
    }

    static int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public static void normal(char[][] graph, int size) {
        int count = 0;
        boolean[][] visit = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (visit[i][j] == false) {
                    normalBfs(graph, visit, size, i, j, graph[i][j]);
                    count++;
                }
            }
        }
        System.out.print(count + " ");
    }

    public static void normalBfs(char[][] graph, boolean[][] visit, int size, int i, int j, char chr) {
        Queue<int[]> q = new ArrayDeque<>();

        q.add(new int[]{i, j});
        visit[i][j] = true;

        while (!q.isEmpty()) {
            int[] e = q.poll();
            int x = e[0]; int y = e[1]; 
            for (int k = 0; k < 4; k++) {
                int dx = x + dir[k][0];
                int dy = y + dir[k][1];
                if (0 <= dx && dx < size && 0 <= dy && dy < size && graph[dx][dy] == chr && visit[dx][dy] == false) {
                    q.add(new int[]{dx, dy});
                    visit[dx][dy] = true;
                }
            }
        }
    }

    public static void protanopia(char[][] graph, int size) {
        int count = 0;
        boolean[][] visit = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (visit[i][j] == false) {
                    protanopiaBfs(graph, visit, size, i, j, graph[i][j]);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static void protanopiaBfs(char[][] graph, boolean[][] visit, int size, int i, int j, char chr) {
        Queue<int[]> q = new ArrayDeque<>();

        q.add(new int[]{i, j});
        visit[i][j] = true;

        while (!q.isEmpty()) {
            int[] e = q.poll();
            int x = e[0]; int y = e[1]; 
            for (int k = 0; k < 4; k++) {
                int dx = x + dir[k][0];
                int dy = y + dir[k][1];
                if (0 <= dx && dx < size && 0 <= dy && dy < size && visit[dx][dy] == false) {
                    if (chr == 'R' || chr == 'G') {
                        if (graph[dx][dy] == 'R' || graph[dx][dy] == 'G') {
                            q.add(new int[]{dx, dy});
                            visit[dx][dy] = true;
                        }
                    } else { // chr == "B"
                        if (graph[dx][dy] == 'B') {
                            q.add(new int[]{dx, dy});
                            visit[dx][dy] = true;
                        }
                    }
                }
            }
        }
    }
}