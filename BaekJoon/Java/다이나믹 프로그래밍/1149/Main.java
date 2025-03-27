import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n + 1][4];

        for (int i = 0; i < n; i++) {
            String[] in = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                graph[i + 1][j + 1] = Integer.parseInt(in[j]);
            }
        }

        solution(n, graph);
        br.close();
    }

    public static void solution(int n, int[][] graph) {
        int[][] dp = new int[n + 1][4];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 3; j++) {
                if (j == 1)
                    dp[i][j] = graph[i][j] + Math.min(dp[i - 1][2], dp[i - 1][3]);
                else if (j == 2)
                    dp[i][j] = graph[i][j] + Math.min(dp[i - 1][1], dp[i - 1][3]);
                else if (j == 3)
                    dp[i][j] = graph[i][j] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            }
        }
        // for (int i = 1; i <= n; i++) {
        //     for (int j = 1; j <= n; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        int result = dp[n][1];
        for (int i = 2; i <= 3; i++) {
            result = Math.min(result, dp[n][i]);
        }
        System.out.println(result);
    }
}