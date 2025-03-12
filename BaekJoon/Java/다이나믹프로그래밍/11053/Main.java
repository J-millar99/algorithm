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
        dp[1] = 1;
        for (int i = 2; i <= n; i++)
            dp[i] = 1 + findMax(dp, i - 1, num[i]);

        int max = 0;
        for (int i = n; i > 0; i--) {
            if (dp[i] > max)
                max = dp[i];
        }
        System.out.println(max);
    }

    public static int findMax(int[] dp, int prev, int target) {
        int max = 0;
        for (int i = prev; i >= 0; i--)
            if (target > num[i])
                max = Math.max(max, dp[i]);
        return max;
    }
}