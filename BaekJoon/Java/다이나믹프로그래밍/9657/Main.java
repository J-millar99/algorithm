import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        if (num == 2)
            System.out.println("CY");
        else
            System.out.println("SK");
        br.close();
    }

    // public static void solution(int num) {
    //     String[] dp = new String[num + 4];
    //     dp[1] = "SK";
    //     dp[2] = "CY";
    //     dp[3] = "SK";
    //     dp[4] = "SK";

    //     for (int i = 5; i <= num; i++) {
    //         dp[i] = dp[i - 1];
    //     }
    //     System.out.println(dp[num]);
    // }
    /*
     * 1 -> SK
     * 2 -> CY
     * 3 -> SK
     * 4 -> SK
     * 5 -> SK : 3을 말한 사람이 승리
     * 6 -> SK : 4를 말한 사람이 승리
     * 7 -> CY : 3을 말한 사람이 패배
     * 8 ->
     * 1. 4로 시작시 SK 패배
     * 2. 3으로 시작시 SK 패배
     * 3. 1로 시작
     *      3-1. 
     *      3-2. 
     *      3-3. 
     */
}