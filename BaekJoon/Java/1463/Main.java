import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    static int[] dp;
    public static int min(int a, int b) {
        return a > b ? b : a;
    }

    // memoinization
    public static void memo(int n) {
        for (int i = 2; i <= n; i++) {
            // 1을 뺀 경우
            dp[i] = dp[i - 1] + 1;

            // 2로 나눈 경우
            if (i % 2 == 0)
                dp[i] = min(dp[i], dp[i / 2] + 1);

            // 3으로 나눈 경우
            if (i % 3 == 0)
                dp[i] = min(dp[i], dp[i / 3] + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        memo(n);

        System.out.println(dp[n]);
        br.close();
    }
}
