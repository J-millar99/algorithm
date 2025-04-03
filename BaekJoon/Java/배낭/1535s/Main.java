import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        String[] in;
        
        int[] cost = new int[num];
        in = br.readLine().split(" ");
        for (int i = 0; i < num; i++) 
            cost[i] = Integer.parseInt(in[i]);
        
        int[] gain = new int[num];
        in = br.readLine().split(" ");
        for (int i = 0; i < gain.length; i++)
            gain[i] = Integer.parseInt(in[i]);
        
        System.out.println(solution(cost, gain, num));
        br.close();
    }    
    
    public static int solution(int[] cost, int[] gain, int size) {
        // dp[j] = 체력 j를 사용했을 때 얻을 수 있는 최대 기쁨
        int[] dp = new int[101]; // 0~100
        
        for (int i = 0; i < size; i++) {
            // 체력을 많이 사용한 상태부터 거꾸로 계산 (중복을 방지)
            for (int j = 100; j > cost[i]; j--) {
                // j-cost[i]만큼 체력을 사용한 상태에서 얻을 수 있는 최대 기쁨에 
                // 현재 사람의 기쁨을 더한 값과 비교
                dp[j] = Math.max(dp[j], dp[j - cost[i]] + gain[i]);
            }
        }
        
        return dp[100];
    }
}