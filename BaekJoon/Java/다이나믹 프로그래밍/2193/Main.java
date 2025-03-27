import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        solution(num);
        br.close();
    }

    public static void solution(int num) {
        long[] dp = new long[num + 4];
        dp[1] = 1; // 1
        dp[2] = 1; // 10
        dp[3] = 2; // 100, 101
        for (int i = 4; i <= num; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[num]);
    }
}