import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int k = Integer.parseInt(in[1]);
        dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1; dp[i][i] = 1;
        }
        solution(n, k);
        br.close();
    }

    public static void solution(int n, int k) {
        for (int i = 2; i <= n; i++) { // n
            for (int j = 1; j < n; j++) { // k
                dp[i][j] = dp[i - 1][j - 1] % 10007 + dp[i - 1][j] % 10007;
            }
        }
        System.out.println(dp[n][k] % 10007);
    }
}