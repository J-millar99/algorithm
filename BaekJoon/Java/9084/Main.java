import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        // 테스트 케이스의 수
        int tries = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < tries; tc++) {
            // 동전 개수
            int num = Integer.parseInt(br.readLine());
            // 동전 종류 입력 줄
            String[] in = br.readLine().split(" ");

            int[] coins = new int[num];
            for (int i = 0; i < num; i++) {
                coins[i] = Integer.parseInt(in[i]);
            }

            // 맞춰야하는 가격
            int price = Integer.parseInt(br.readLine());
            solution(num, coins, price);
        }
        System.out.print(sb);
        br.close();
    }

    public static void solution(int num, int[] coins, int price) {
        int[] dp = new int[price + 1];
        for (int i = 0; i < num; i++) {
            int coin = coins[i];
            if (coin > price)
                continue;
            dp[coin] += 1;
            for (int j = coin; j <= price; j++) {
                dp[j] += dp[j - coin];
            }
        }
        sb.append(dp[price]).append("\n");
    }
}
