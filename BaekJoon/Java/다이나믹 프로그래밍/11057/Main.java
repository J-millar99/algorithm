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
        int[][] dp = new int[len + 1][10];
        for (int i = 0; i < 10; i++) { // 한 자리수는 0~9까지 각각 1개
            dp[1][i] = 1;
        }

        for (int i = 2; i <= len; i++) {
            for (int j = 0; j < 10; j++) { 
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i - 1][k];
                    dp[i][j] %= 10007;
                }
            }
        }
            
        int sum = 0;
        for (int j = 0; j < 10; j++) {
            sum += dp[len][j];
            sum %= 10007;
        }
        
        System.out.println(sum);
    }
}
    
