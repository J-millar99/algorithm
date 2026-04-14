import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int weight[];
    static int value[];
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] in;
        
        weight = new int[n];
        in = br.readLine().split(" ");
        for (int i = 0; i < n; i++) 
            weight[i] = Integer.parseInt(in[i]);
        
        value = new int[n];
        in = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            value[i] = Integer.parseInt(in[i]);
        
        int[][] memo = new int[n + 1][100];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        System.out.println(solutionRecursive(n, 99, memo));
        br.close();
    }

    public static int solutionDP(int n) {
        int capacity = 99;
        int dp[][] = new int[n + 1][capacity + 1];

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

    public static int solutionRecursive(int n, int capacity, int[][] memo) {
        if (n == 0 || capacity == 0) 
            return 0;
        
        if (memo[n][capacity] != -1)
            return memo[n][capacity];
        
        if (weight[n - 1] <= capacity) {
            memo[n][capacity] = Math.max(value[n - 1] + solutionRecursive(n - 1, capacity - weight[n - 1], memo),
            solutionRecursive(n - 1, capacity, memo));
        }
        else
            memo[n][capacity] = solutionRecursive(n - 1, capacity, memo);
        return memo[n][capacity];
    }
}
