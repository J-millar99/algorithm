import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int k = Integer.parseInt(in[1]);

        in = br.readLine().split(" ");
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(in[i]);
        }
        int left, right, count, dup, result;

        left = 0;
        right = 1;
        count = 0;
        dup = 0;
        result = 0;
        while (right != n - 1) {
            if (num[left] != num[right])
                dup = 0;
            else
                dup++;
            left++; right++;
            if (dup == k) {
                result = Math.max(count, result);
                dup = count = 0;
            } else
                count++;
        }
        System.out.println(Math.max(count, result));
        br.close();
    }
}