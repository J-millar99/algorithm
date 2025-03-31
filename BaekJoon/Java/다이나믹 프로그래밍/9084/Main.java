import java.io.*;
import java.util.*;

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

            sb.append(solution(num, coins, price)).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    public static int solution(int num, int[] coins, int price) {
        int[] dp = new int[num + 1];

        for (int i = 1; i <= price; i++) {
            if (binarySearch(coins, i))
                dp[i]++;
        }
        return dp[price];
    }

    public static boolean binarySearch(int[] arr, int find) {
        int s = 0;
        int e = arr.length - 1;

        while (s <= e) {
            int m = (s + e) / 2;
            int target = arr[m];
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
