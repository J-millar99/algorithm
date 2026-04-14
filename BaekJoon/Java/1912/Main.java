import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] num;
    static int n;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        String[] in = br.readLine().split(" ");
        num = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(in[i - 1]);
        }
        solution();
        br.close();
    }
    public static void solution() {
        int[] dp = new int[n + 1];
        dp[1] = num[1];
        int maxValue = dp[1];
        for (int i = 2; i <= n; i++) {
            dp[i] = num[i];
            if (dp[i - 1] > 0)
                dp[i] += dp[i - 1];
            maxValue = Math.max(maxValue, dp[i]);
        }
        System.out.println(maxValue);
    }
}