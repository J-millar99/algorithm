import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] field = new int[n][3];
        for (int i = 0; i < n; i++) {
            String[] in = br.readLine().split(" ");
            field[i][0] = Integer.parseInt(in[0]);
            field[i][1] = Integer.parseInt(in[1]);
            field[i][2] = Integer.parseInt(in[2]);
        }

        int[][] dp = new int[n][3];
        dp[0][0] = field[0][0]; dp[0][1] = field[0][1]; dp[0][2] = field[0][2];

        dp[1][0] = field[1][0] + Math.min(dp[0][1], dp[0][2]);
        dp[1][1] = field[1][1] + Math.min(dp[0][0], dp[0][2]);
        dp[1][2] = field[1][2] + Math.min(dp[0][0], dp[0][1]);
 
        // 처음과 마지막 row는 합산 계산이 다르게 반영
        for (int i = 2; i < n; i++) {
            dp[i][0] = field[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = field[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = field[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            answer = Math.min(answer, dp[n - 1][i]);
        }
        br.close();
        System.out.println(answer);
    }
}
