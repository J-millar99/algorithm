import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int tries = Integer.parseInt(br.readLine());

        for (int i = 0; i < tries; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] in = br.readLine().split(" ");
            int[] coins = new int[n];
            for (int j = 0; j < n; j++) {
                coins[j] = Integer.parseInt(in[j]);
            }
            int target = Integer.parseInt(br.readLine());

            sb.append(solution(coins, n, target)).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    public static int solution(int[] coins, int n, int target) {
        int dp[] = new int[target + 1];

        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= target; j++) {
                if (j == coins[i])
                    dp[j] += 1;
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[target];
    }
}