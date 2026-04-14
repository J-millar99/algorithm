import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[][] board = new int[9][9];
    static boolean[][] rowUsed = new boolean[9][10];
    static boolean[][] colUsed = new boolean[9][10];
    static boolean[][] boxUsed = new boolean[9][10];
    static List<String> results = new ArrayList<>();
    static boolean earlyStop = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<int[]> blanks = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            String[] in = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) 
                board[i][j] = Integer.parseInt(in[j]);
        }
        br.close();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int val = board[i][j];
                if (val != 0) {
                    rowUsed[i][val] = true;
                    colUsed[j][val] = true;
                    boxUsed[(i / 3) * 3 + (j / 3)][val] = true;
                } else {
                    blanks.add(new int[]{i, j});
                }
            }
        }
        backtrack(0, blanks);
    }

    static void backtrack(int idx, List<int[]> blanks) {
        if (idx == blanks.size()) {
            StringBuilder sb = new StringBuilder();
            for (int[] rows : board) {
                for (int val : rows)
                    sb.append(val).append(" ");
                sb.append("\n");
            }
            System.out.print(sb);
            earlyStop = true;
            return ;
        }
        int[] pos = blanks.get(idx);
        int x = pos[0];
        int y = pos[1];

        for (int num = 1; num <= 9; num++) {
            int boxIdx = (x / 3) * 3 + (y / 3);
            if (rowUsed[x][num] || colUsed[y][num] || boxUsed[boxIdx][num])
                continue;

            board[x][y] = num;
            rowUsed[x][num] = true;
            colUsed[y][num] = true;
            boxUsed[boxIdx][num] = true;

            backtrack(idx + 1, blanks);

            if (earlyStop == true) // 재귀 풀기
                return ;
            
            board[x][y] = 0;
            rowUsed[x][num] = false;
            colUsed[y][num] = false;
            boxUsed[boxIdx][num] = false;
        }
    }
}
