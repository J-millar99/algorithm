import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        solution(num);
        br.close();
    }

    public static void solution(int num) {
        int[] dp = new int[num + 4];
        // 1은 SK, 0은 CY
        dp[1] = 1;
        dp[2] = 0;
        dp[3] = 1;
        dp[4] = 1;

        /* 
         * 7은 CY의 승리이다.
         * 7은 3, 4, 6에서 올 수 있다. (각각 4, 3, 1을 부르는 것)
         * 3, 4, 6에서 모두 SK가 이겼다면 7에서는 CY가 이길 수 밖에 없다.
         * 왜냐하면 3, 4, 6를 만들었던 차례가 SK이기 때문에 다음 차례 한 번으로 CY는 7를 만들 수 있다.
         * 
         * 반면 5는 SK의 승리이다.
         * 5는 1, 2, 4에서 올 수 있다. (각각 4, 3, 1을 부르는 것)
         * 1, 4는 SK가 무조건 만들 수 있다. 그러면 SK는 2를 만드려하지 않아야 한다. 2에서 CY가 차례 한 번으로 5를 만들기 때문이다.
         * 왜냐하면 1, 2, 4를 만들었던 차례가 SK이기 때문에 다음 차례 한 번으로 CY는 5를 만들 수 있다.
         */
        for (int i = 5; i <= num; i++) {
            if (dp[i - 1] + dp[i - 3] + dp[i - 4] < 3)
                dp[i] = 1;
            else
                dp[i] = 0;
        }
        if (dp[num] == 1)
            System.out.println("SK");
        else
            System.out.println("CY");
    }
}