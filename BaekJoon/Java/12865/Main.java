import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] value, weight;
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");

        int n = Integer.parseInt(in[0]);
        int capacity = Integer.parseInt(in[1]);

        weight = new int[n];
        value = new int[n];
        for (int i = 0; i < n; i++) {
            in = br.readLine().split(" ");
            int w = Integer.parseInt(in[0]);
            int v = Integer.parseInt(in[1]);
            weight[i] = w;
            value[i] = v;
        }

        System.out.println(solution(n, capacity));

        // int[][] memo = new int[n + 1][capacity + 1];
        // for (int[] row : memo) {
        //     Arrays.fill(row, -1);
        // }
        // System.out.println(solution2(n, capacity, memo));
        br.close();
    }

    public static int solution(int n, int capacity) {
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (weight[i - 1] <= j)
                    dp[i][j] = Math.max(value[i - 1] + dp[i - 1][j - weight[i - 1]], dp[i - 1][j]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][capacity];
    }

    public static int solution2(int n, int capacity, int[][] memo) {
        if (n == 0 || capacity == 0)
            return 0;
        if (memo[n][capacity] != -1)
            return memo[n][capacity];
        if (weight[n - 1] <= capacity)
            memo[n][capacity] = Math.max(value[n - 1] + solution2(n - 1, capacity - weight[n - 1], memo),
            solution2(n - 1, capacity, memo));
        else
            memo[n][capacity] = solution2(n - 1, capacity, memo);
        return memo[n][capacity];
    }
}