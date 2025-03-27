import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        int[] cards = new int[num + 1];
        String[] in = br.readLine().split(" ");
        for (int i = 1; i <= num; i++) {
            cards[i] = Integer.parseInt(in[i - 1]);
        }
        solution(num, cards);
        br.close();
    }

    public static void solution(int num, int[] cards) {
        int[] dp = new int[num + 1];
        dp[1] = cards[1];
        for (int i = 2; i <= num; i++) {
            dp[i] = cards[i];
            dp[i] = Math.max(dp[i], dp[i / 2] * 2);
        }
    }
}