import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        solution(num);
        br.close();
    }

    public static void solution(int num) {
        int[] dp = new int[num + 1];
        StringBuilder sb = new StringBuilder();

        dp[1] = 0;
        for (int i = 2; i <= num; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0)
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            if (i % 3 == 0) 
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }
        sb.append(dp[num]).append("\n");

        int temp = num;
        sb.append(temp).append(" ");
        while (temp > 1) {
            int next = temp - 1;
            int minDp = dp[next];

            if (temp % 3 == 0 && dp[temp / 3] <= minDp) {
                next = temp / 3;
                minDp = dp[next];
            }
            if (temp % 2 == 0 && dp[temp / 2] <= minDp) {
                next = temp / 2;
                minDp = dp[next];
            }
            temp = next;
            sb.append(temp).append(" ");
        }
        System.out.println(sb);
    }
}