import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");

        int num = Integer.parseInt(in[0]);
        int price = Integer.parseInt(in[1]);

        List<Integer> coins = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            int coin = Integer.parseInt(br.readLine());
            coins.add(coin);
        }
        Collections.sort(coins);

        System.out.println(solution(coins, price));
        br.close();
    }

    public static int solution(List<Integer> coins, int price) {
        int[] dp = new int[price + 1];

        Arrays.fill(dp, -1);
        if (coins.get(0) == 1)
            dp[1] = 1;

        if (price == 1)
            return dp[1];

        for (int i = 2; i <= price; i++) {
            if (binarySearch(coins, i))
                dp[i] = 1;
            else
                dp[i] = combination(dp, i);
        }
        return dp[price];
    }

    public static int combination(int[] dp, int end) {
        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= end / 2; i++) {
            if (dp[i] == -1 || dp[end - i] == -1)
                continue;
            int sum = dp[i] + dp[end - i];
            result = Math.min(result, sum);
        }
        if (result == Integer.MAX_VALUE)
            return -1;
        return result;
    }

    public static boolean binarySearch(List<Integer> arr, int find) {
        int s = 0;
        int e = arr.size() - 1;

        while (s <= e) {
            int m = (s + e) / 2;
            int target = arr.get(m);
            if (target == find)
                return true;
            else if (target > find)
                e = m - 1;
            else
                s = m + 1;
        }
        return false;
    }
}
