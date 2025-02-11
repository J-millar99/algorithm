import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static int min(int a, int b) {
        return a > b ? b : a;
    }


    public static void dpf(int dp[], int n) {
        if (dp[n] != 0)
            return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        dpf(dp, n);
        System.out.println(dp[n]);
        br.close();
    }
}
