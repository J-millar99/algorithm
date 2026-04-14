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
        solution(field, n);
        br.close();
    }

    public static void solution(int[][] field, int n) {
        final int INF = 1000000;
        int answer = INF;
        for (int firstColor = 1; firstColor <= 3; firstColor++) {
            int[][] dp = new int[n + 1][4];

            // 첫 번째 색을 선택하고 나머지는 선택되지 않게 초기화
            for (int color = 1; color <= 3; color++) {
                if (color == firstColor)
                    dp[1][color] = field[1][color];
                else
                    dp[1][color] = INF;
            }

            // System.out.println(dp[1][1] + " " + dp[1][2] + " " + dp[1][3]);
            for (int i = 2; i <= n; i++) {
                dp[i][1] = field[i][1] + Math.min(dp[i - 1][2], dp[i - 1][3]);
                dp[i][2] = field[i][2] + Math.min(dp[i - 1][1], dp[i - 1][3]);
                dp[i][3] = field[i][3] + Math.min(dp[i - 1][1], dp[i - 1][2]);
                // System.out.println(dp[i][1] + " " + dp[i][2] + " " + dp[i][3]);
            }

            for (int lastColor = 1; lastColor <= 3; lastColor++) {
                if (lastColor != firstColor)
                    answer = Math.min(answer, dp[n][lastColor]);
            }
        }
        System.out.println(answer);
    }
}