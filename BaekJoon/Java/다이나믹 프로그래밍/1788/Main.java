import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        n += 1000000;
        solution(n);
        br.close();
    }

    public static void solution(int n) {
        int[] dp = new int[2000001];
        dp[1000000] = 0; // fib[0]
        dp[1000001] = 1; // fib[1]

        for (int i = 1000002; i <= n; i++) { // fib[2]부터
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000000;
        }
        for (int i = 999999; i >= 0; i--) { // fib[-1]부터
            dp[i] = (dp[i + 2] - dp[i + 1]) % 1000000000; 
        }

        if (dp[n] > 0)
            System.out.println(1 + "\n" + dp[n]);
        else if (dp[n] == 0)
            System.out.println(0 + "\n" + 0);
        else
            System.out.println(-1 + "\n" + (dp[n] * -1));
    }
}