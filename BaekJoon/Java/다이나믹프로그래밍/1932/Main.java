import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<Integer> temp = new ArrayList<>();
            String[] in = br.readLine().split(" ");
            for (int j = 0; j < in.length; j++) {
                temp.add(Integer.parseInt(in[j]));
            }
            arr.add(temp);
        }

        solution(arr, size);
        br.close();
    }

    public static void solution(List<List<Integer>> arr, int size) {
        int[][] dp = new int[size + 1][size + 1];

        dp[1][1] = arr.get(0).get(0);
        for (int i = 2; i <= size; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = arr.get(i - 1).get(j - 1);
                if (j == 1)
                    dp[i][j] += dp[i - 1][j];
                else if (j == i)
                    dp[i][j] += dp[i - 1][j - 1];
                else
                    dp[i][j] += Math.max(dp[i - 1][j - 1],dp[i - 1][j]);
            }
        }

        int max = 0;
        for (int num : dp[size]) {
            if (max < num)
                max = num;
        }
        System.out.println(max);
    }
}