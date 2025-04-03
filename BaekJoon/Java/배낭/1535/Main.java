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
        
        solution(cost, gain, num);
        br.close();
    }    
    
    public static void solution(int[] cost, int[] gain, int size) {
        int[][] arr = new int[size][2];

        for (int i = 0; i < size; i++) {
            arr[i][0] = cost[i];
            arr[i][1] = gain[i];
        }

        Arrays.sort(arr, (a, b) -> {
            double ratio1 = joyPerDamage(a[0], a[1]);
            double ratio2 = joyPerDamage(b[0] ,b[1]);

            if (ratio1 == ratio2)
                return Integer.compare(a[0], b[0]);
            return Double.compare(ratio2, ratio1);
        });


        int result = 0;
        int i = 0;
        while (i < size) {
            int j = i;
            int hp = 100;
            int joy = 0;
            while (j < size) {
                int minus = arr[j][0];
                int plus = arr[j][1];
                if (hp - minus > 0) {
                    joy += plus;
                    hp -= minus;
                }
                j++;
            }
            i++;
            result = Math.max(result, joy);
        }
        System.out.println(result);
    }

    public static double joyPerDamage(int damage, int joy) {
        return (double)joy / (double)damage;
    }
}
