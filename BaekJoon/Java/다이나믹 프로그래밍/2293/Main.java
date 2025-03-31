import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int num;
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");

        num = Integer.parseInt(in[0]);
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
        if (coins.get(0) == 1)
            dp[1] = 1;

        for (int i = 2; i <= price; i++) {
            if (binarySearch(coins, i))
                dp[i]++;
            dp[i] += combination(dp, coins, i);
        }
        return dp[price];
    }

    public static int combination(int[] dp, List<Integer> coins, int target) {
        int result = 0;
        for (int i = 1; i < target; i++) {
            for (int j = 0; j < num; j++) {
                if (i + coins.get(j) == target) {
                    result += dp[i];
                }
            }
        }
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