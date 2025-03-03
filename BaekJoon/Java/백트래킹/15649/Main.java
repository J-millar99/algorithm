import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] board;
    static int n, m, i;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        board = new int[m];
        backTracking(0);
        System.out.print(sb);
        br.close();
    }

    public static void backTracking(int i) {
        if (i >= m) {
            for (int num : board)
                sb.append(num).append(" ");
            sb.append("\n");
            return;
        }

        for (int v = 0; v < n; v++) {
            board[i] = v + 1;
        }
    }
}