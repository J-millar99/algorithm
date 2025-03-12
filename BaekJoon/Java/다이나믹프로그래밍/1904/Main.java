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
        // 크기가 1인 1타일, 크기가 2인 00타일만 존재
        dp[1] = 1; // 1
        dp[2] = 2; // 00, 11
        dp[3] = 3; // 001, 111, 100
        for (int i = 4; i <= num; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
        }
        System.out.println(dp[num]);
    }
}