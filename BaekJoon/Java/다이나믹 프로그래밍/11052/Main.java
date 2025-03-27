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
        System.out.println(solution(num, cards));
        br.close();
    }

    public static int solution(int num, int[] cards) {
        int[] dp = new int[num + 1];

        dp[1] = cards[1];
        if (num == 1)
            return cards[1];

        
        dp[2] = Math.max(cards[2], dp[1] * 2);
        if (num == 2)
            return dp[num];


        for (int i = 3; i <= num; i++)
            dp[i] = Math.max(cards[i], combination(dp, i));

        return dp[num];
    }

    public static int combination(int[] dp, int end) {
        int result = 0;
        for (int i = 1; i <= end / 2; i++) {
            int sum = dp[i] + dp[end - i];
            result = Math.max(result, sum);
        }
        return result;
    }
}