import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        int[] dp = new int[num + 2];

        dp[1] = 2;
        dp[2] = 4;
        int p = 3;
        for (int i = 3; i <= num; i++) {
            dp[i] = dp[i - 1] + p;
            if (i % 3 != 0)
                p++;
        }
        System.out.println(dp[num]);
        br.close();
    }
}