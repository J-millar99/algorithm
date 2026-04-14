import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int[] alpha = new int[26];
        String str = br.readLine();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            int idx = str.charAt(i) - 'A';
            alpha[idx] += 1;
        }

        int odd = 0;
        int oddi = 0;
        for (int i = 0; i < 26; i++) 
            if (alpha[i] % 2 == 1) {
                odd++;
                oddi = i;
            }
        if (odd >= 2)
            System.out.println("I'm Sorry Hansoo");
        else {
            char[] newStr = new char[len];
            int idx = 0;
            for (int i = 0; i < 26; i++) {
                int step = alpha[i] / 2;
                for (int j = idx; j < idx + step; j++) {
                    newStr[j] = (char)('A' + i);
                    newStr[len - j - 1] = (char)('A' + i);
                }
                idx+=step;
            }
            if (odd != 0)
                newStr[len / 2] = (char)('A' + oddi);
            for (int i = 0; i < len; i++) {
                System.out.print(newStr[i]);
            }
            System.out.println();
        }
        br.close();
    }
}