import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        solution(num);
        br.close();
    }

    public static void solution(int num) {
        int[] dp = new int[num + 3];
        dp[1] = 1;
        for (int i = 2; i <= num; i++) {
            int root = (int)Math.sqrt(i);
            int square = root * root;
            if (square == i) // 제곱수라면 경우의 수는 1
                dp[i] = 1;
            else { // 제곱수가 아니라면
                dp[i] = 4;
                for (int j = 1; j <= i / 2; j++) { // dp배열의 좌 우 끝값의 합으로 최소 비교
                    dp[i] = Math.min(dp[j] + dp[i - j], dp[i]);
                }
            }
        }
        System.out.println(dp[num]);
    }
}