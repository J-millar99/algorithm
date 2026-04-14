import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tries = Integer.parseInt(br.readLine());

        for (int i = 0; i < tries; i++) {
            int n = Integer.parseInt(br.readLine());
            padovanSequence(n);
        }
        br.close();
    }

    public static void padovanSequence(int n) {
        long[] dp = new long[n + 2];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++)
            dp[i] = dp[i - 2] + dp[i - 3];
        System.out.println(dp[n]);
    }
    // 자료형에 주의해야 함.
}
