import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] vip = new int[n];
        for (int i = 0; i < n; i++) {
            vip[i] = Integer.parseInt(br.readLine());
        }

        solution(vip, num);
        br.close();
    }

    public static void solution(int[] vip, int num) {
        int[] dp = new int[num + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= num; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        int loc = 1;
        int result = 1;
        for (int v : vip) {
            result *= getSum(v, loc, dp);
            loc = v + 1;
        }
        result *= getSum(num + 1, loc, dp);
        System.out.println(result);
    }

    public static int getSum(int v, int loc, int[] dp) {
        int size = v - loc;
        if (size == 0)
            return 1;
        return dp[size];
    }
}