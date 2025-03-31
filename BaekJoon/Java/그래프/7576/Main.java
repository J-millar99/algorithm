import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        int row = Integer.parseInt(in[1]);
        int col = Integer.parseInt(in[0]);
        int[][] field = new int[row][col];
        Queue<int[]> q = new ArrayDeque<>();
        int unripen = 0;

        for (int i = 0; i < row; i++) {
            in = br.readLine().split(" ");
            for (int j = 0; j < col; j++) {
                field[i][j] = Integer.parseInt(in[j]);
                if (field[i][j] == 1)
                    q.add(new int[]{i, j});
                else if (field[i][j] == 0)
                    unripen++;
            }
        }

        solution(q, field, unripen, row, col);
        br.close();
    }

    public static void solution(Queue<int[]> q, int[][] field, int unripen, int row, int col) {
        int day = 0;
        boolean changed = false;
        while (!q.isEmpty()) {
            changed = false;
            int size = q.size();
            for (int k = 0; k < size; k++) {       
                int[] pos = q.poll();
                int r = pos[0];
                int c = pos[1];
                field[r][c] = 2;
                
                for (int i = 0; i < 4; i++) {
                    int dr = r + dir[i][0];
                    int dc = c + dir[i][1];
                    if (dr < 0 || dr >= row || dc < 0 || dc >= col
                    || field[dr][dc] != 0)
                        continue;
                    field[dr][dc] = 1;
                    unripen--;
                    q.add(new int[]{dr, dc});
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