import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] weight, cost;
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        int capacity = Integer.parseInt(in[0]);
        int n = Integer.parseInt(in[1]);

        weight = new int[n];
        cost = new int[n];
        for (int i = 0; i < n; i++) {
            in = br.readLine().split(" ");
            cost[i] = Integer.parseInt(in[0]);
            weight[i] = Integer.parseInt(in[1]);
        }
        System.out.println(solution(n, capacity));
        br.close();
    }

    public static int solution(int n, int capacity) {
        int[][] dp = new int[capacity + 1][2];
        for (int i = 1; i <= capacity; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }
        dp[0][0] = dp[0][1] = 0;
        for (int w = 1; w <= capacity; w++) {
            for (int i = 0; i < n; i++) {
                // 이전에 이미 인원 수를 만족한 경우
                if (dp[w - 1][1] >= w) {
                    dp[w][0] = dp[w - 1][0];
                    dp[w][1] = dp[w - 1][1];
                    continue;
                }
                int prev = w - weight[i];
                if (prev >= 0 && dp[prev][0] + cost[i] < dp[w][0]) {
                    dp[w][0] = dp[prev][0] + cost[i];
                    dp[w][1] = dp[prev][1] + weight[i];
                } else if (prev < 0) {
                    if (cost[i] < dp[w][0]) {
                        dp[w][0] = cost[i];
                        dp[w][1] = weight[i];
                    }
                }
            }
        }
        return dp[capacity][0];
    }
}