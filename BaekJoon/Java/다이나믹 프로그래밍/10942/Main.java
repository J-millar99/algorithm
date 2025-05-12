import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        String[] in = br.readLine().split(" ");

        for (int i = 1; i <= n; i++) 
            arr[i] = Integer.parseInt(in[i - 1]);
        solution(arr, n);

        int tries = Integer.parseInt(br.readLine());
        for (int i = 0; i < tries; i++) {
            in = br.readLine().split(" ");
            int s = Integer.parseInt(in[0]);
            int e = Integer.parseInt(in[1]);
            sb.append(dp[s][e]).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    public static void solution(int[] arr, int n) {
        dp = new int[n + 1][n + 1];

        init(n, arr); // 첫 dp[1]의 팰린드롬 여부를 기록

        for (int s = 2; s <= n; s++) {
            for (int e = s; e <= n; e++) {
                if (s == e) {
                    dp[s][e] = 1; // 크기 1은 팰린드롬
                    continue;
                }
                if (dp[s - 1][e] == 1) { // 이전이 팰린드롬일 때
                    if (arr[s - 1] == arr[s]) // 11111와 같이 같은 수가 연속된 경우에만 팰린드롬이 유지
                        dp[s][e] = 1;
                } else {
                    if (isPalindrome(arr, s, e))
                        dp[s][e] = 1;
                }
            }
        }

    }

    public static boolean isPalindrome(int[] arr, int s, int e) {
        while (s < e) {
            if (arr[s] != arr[e])
                return false;
            s++;
            e--;
        }
        return true;
    }

    public static void init(int n, int[] arr) {
        // init
        for (int len = 1; len <= n; len++) {
            int s = 1;
            int e = len;
            dp[1][e] = 1;
            while (s < e) {
                if (arr[s] != arr[e]) {
                    dp[1][len] = 0;
                    break;
                }
                s++;
                e--;
            }
        }
    }
}