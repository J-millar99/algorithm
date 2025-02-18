import java.util.*;
import java.io.*;

public class Main {
    static int[] dp;
    static List<Integer> stairs = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 인덱스와 개수를 동일하게 하기위해 인덱스 0에 0값을 추가
        stairs.add(0);
        for (int i = 0; i < n; i++)
            stairs.add(Integer.parseInt(br.readLine()));

        System.out.println(memo(n));
        br.close();
    }

    public static int memo(int n) {
        dp = new int[n + 1];

        dp[1] = stairs.get(1);
        if (n == 1)
            return dp[1];

        dp[2] = dp[1] + stairs.get(2);
        if (n == 2)
            return dp[2];

        for (int i = 3; i < n + 1; i++)
            dp[i] = stairs.get(i) + Math.max(dp[i - 2], stairs.get(i - 1) + dp[i - 3]);

        return dp[n];
    }
}
