import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] field = new int[n + 1][4];
        for (int i = 1; i <= n; i++) {
            String[] in = br.readLine().split(" ");
            field[i][1] = Integer.parseInt(in[0]);
            field[i][2] = Integer.parseInt(in[1]);
            field[i][3] = Integer.parseInt(in[2]);
        }
        System.out.println(solution(field, n));
        br.close();
    }

    public static int solution(int[][] field, int n) {
        int[][] dp = new int[n + 1][4];
        
        // init
        dp[1][1] = field[1][1];
        dp[1][2] = field[1][2];
        dp[1][3] = field[1][3];

        dp[2][1] = field[2][1] + Math.min(field[1][2], field[1][3]); 
        dp[2][2] = field[2][2] + Math.min(field[1][1], field[1][3]);
        dp[2][3] = field[2][3] + Math.min(field[1][1], field[1][2]);

        for (int i = 3; i <= n; i++) {
            dp[i][1] = field[i][1] + Math.min(dp[i - 2][2] + field[i - 1][3], dp[i - 2][3] + field[i - 1][2]);
            dp[i][2] = field[i][2] + Math.min(dp[i - 2][1] + field[i - 1][3], dp[i - 2][3] + field[i - 1][1]);
            dp[i][3] = field[i][3] + Math.min(dp[i - 2][1] + field[i - 1][2], dp[i - 2][2] + field[i - 1][1]);
        }
        return Math.min(Math.min(dp[n][1], dp[n][2]), dp[n][3]);
    }
}