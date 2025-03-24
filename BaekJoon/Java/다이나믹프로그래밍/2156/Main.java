import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        int[] wine = new int[num + 2];
        for (int i = 1; i <= num; i++) {
            String in = br.readLine();
            wine[i] = Integer.parseInt(in);
        }

        solution(wine, num);
        System.out.print(sb);
        br.close();
    }

    public static void solution(int[] wine, int num) {
        int[] dp = new int[num + 2];
        // bottom up
        dp[1] = wine[1];
        dp[2] = wine[2] + wine[1];
        for (int i = 3; i <= num; i++) {
            dp[i] = Math.max(dp[i - 1], wine[i] + Math.max(dp[i - 2], wine[i - 1] + dp[i - 3]));
        }

        System.out.println(dp[num]);
    }
}