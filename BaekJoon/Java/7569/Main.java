import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int[] fdir = {1, -1};
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        int row = Integer.parseInt(in[1]);
        int col = Integer.parseInt(in[0]);
        int floor = Integer.parseInt(in[2]);
        int[][][] field = new int[floor][row][col];
        Queue<int[]> q = new ArrayDeque<>();
        int unripen = 0;

        for (int k = 0; k < floor; k++) {
            for (int i = 0; i < row; i++) {
                in = br.readLine().split(" ");
                for (int j = 0; j < col; j++) {
                    field[k][i][j] = Integer.parseInt(in[j]);
                    if (field[k][i][j] == 1)
                        q.add(new int[]{i, j, k});
                    else if (field[k][i][j] == 0)
                        unripen++;
                }
            }
        }
            
        solution(q, field, unripen, row, col, floor);
        br.close();
    }

    public static void solution(Queue<int[]> q, int[][][] field, int unripen, int row, int col, int floor) {
        int day = 0;
        boolean changed = false;
        while (!q.isEmpty()) {
            changed = false;
            int size = q.size();
            for (int k = 0; k < size; k++) {       
                int[] pos = q.poll();
                int r = pos[0];
                int c = pos[1];
                int f = pos[2];
                field[f][r][c] = 2;

                for (int i = 0; i < 2; i++) {
                    int df = f + fdir[i];
                    if (df < 0 || df >= floor
                    || field[df][r][c] != 0)
                        continue;
                    field[df][r][c] = 1;
                    unripen--;
                    q.add(new int[]{r, c, df});
                    changed = true;
                }

                for (int i = 0; i < 4; i++) {
                    int dr = r + dir[i][0];
                    int dc = c + dir[i][1];
                    if (dr < 0 || dr >= row || dc < 0 || dc >= col
                    || field[f][dr][dc] != 0)
                        continue;
                    field[f][dr][dc] = 1;
                    unripen--;
                    q.add(new int[]{dr, dc, f});
                    changed = true;
                }
            }
            if (changed)
                day++;
            else
                break;
        }
        if (unripen == 0)
            System.out.println(day);
        else
            System.out.println("-1");
    }
}