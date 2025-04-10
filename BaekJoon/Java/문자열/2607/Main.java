import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int len1 = str.length();
        int[] dic = new int[26];
        for (int i = 0; i < len1; i++) {
            int key = str.charAt(i) - 'A';
            dic[key] += 1;
        }

        int count = 0;
        for (int i = 0; i < num - 1; i++) {
            str = br.readLine();
            int[] tmp = new int[26];
            int len2 = str.length();
            for (int idx = 0; idx < len2; idx++) {
                int key = str.charAt(idx) - 'A';
                tmp[key] += 1;
            }
            if (Math.abs(len1 - len2) >= 2)
                continue;
            if (compare(dic, tmp) == true)
                count++;
        }
        System.out.println(count);
        br.close();
    }

    public static boolean compare(int[] dic, int[] tmp) {
        int plus = 0;
        int minus = 0;
        for (int i = 0; i < 26; i++) {
            if (dic[i] > tmp[i])
                plus += dic[i] - tmp[i];
            else if (dic[i] < tmp[i])
                minus += tmp[i] - dic[i];
        }
        if ((plus == 0 && minus == 0) || (plus <= 1 && minus <= 1 && plus + minus <= 2))
            return true;
        return false;
    }
}
