import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int len = Integer.parseInt(br.readLine());
        solution(len);
        br.close();
    }

    public static void solution(int len) {
        long[][] dp = new long[len + 1][10]; // 0 ~ 9 자리수 개수를 저장

        for (int i = 1; i <= 9; i++) {  // 한 자리수는 0 ~ 9 까지 한 개임
            dp[1][i] = 1;
        }
        dp[1][0] = 0;
        for (int i = 2; i <= len; i++) {
            // 다음 끝자리 수, n의 개수는 이전 끝자리수 (n - 1)과 (n + 1)이 만들 수 있다.
            // 단 0과 9를 만들 때 주의해야한다.
            dp[i][0] = dp[i - 1][1];
            dp[i][9] = dp[i - 1][8];
            for (int j = 1; j < 9; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
            }
        }

        long sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum += (dp[len][i] % 1000000000);
        }
        System.out.println(sum % 1000000000);
    }
}