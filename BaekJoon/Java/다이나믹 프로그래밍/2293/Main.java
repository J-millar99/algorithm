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

        solution(coins, price);
        br.close();
    }

    public static void solution(List<Integer> coins, int price) {
        int[] dp = new int[price + 1];
        int size = coins.size();
        for (int i = 0; i < size; i++) {
            int coin = coins.get(i);
            if (coin > price)
                continue;
            dp[coin] += 1;
            for (int j = coin; j <= price; j++) {
                dp[j] += dp[j - coin];
            }
        }
        System.out.println(dp[price]);
    }
}