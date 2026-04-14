import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int tries = Integer.parseInt(br.readLine());
        for (int i = 0; i < tries; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 2)
                solution(num);
            else
                sb.append(num).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    public static void solution(int num) {
        int[] dp = new int[num + 1];
        dp[1] = 1; // 1
        dp[2] = 2; // 1 + 1, 2
        dp[3] = 4; // 1 + 1 + 1, 1 + 2, 2 + 1, 3;
        for (int i = 4; i <= num; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        sb.append(dp[num]).append("\n");
    }
}