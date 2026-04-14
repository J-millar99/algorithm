import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] dp = new int[41][2]; // row: n(0~40), col: 0 or 1
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tries = Integer.parseInt(br.readLine());

        fibonacciDP();
        for (int i = 0; i < tries; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n][0] + " " + dp[n][1]);
        }
        br.close();
    }

    public static void fibonacciDP() {
        // (a, b)에 대하여 a는 0의 등장 개수 b는 1의 등장 개수

        // fibonacci 0은 0이므로 (1, 0)
        dp[0][0] = 1;
        dp[0][1] = 0;

        // fibonacci 1은 1이므로 (0, 1)
        dp[1][0] = 0;
        dp[1][1] = 1;

        // fibonacci 2는 fibonacci 0 + fibonacci 1 이므로
        dp[2][0] = dp[0][0] + dp[1][0];
        dp[2][1] = dp[0][1] + dp[1][1];

        // fibonacci 3은 fibonacci 1 + fibonacci 2 이므로, 여기서 fibonacci 2는 이전에 구한 결과가 Array에 존재
        // 일반화-> fibonacci n = fibonacci(n - 2) + fibonacci(n - 1)
        for (int i = 3; i < 41; i++) {
            dp[i][0] = dp[i - 2][0] + dp[i - 1][0];
            dp[i][1] = dp[i - 2][1] + dp[i - 1][1];
        }
    }
}