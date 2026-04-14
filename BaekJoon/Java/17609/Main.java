import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            String str = br.readLine();
            int len = str.length();
            if (isPalindrome(str, len))
                sb.append(0);
            else if (isPseudo(str, len))
                sb.append(1);
            else
                sb.append(2);
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    public static boolean isPalindrome(String str, int len) {
        int limit = len / 2;
        for (int i = 0; i < limit; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1))
                return false;
        }
        return true;
    }

    public static boolean isPseudo(String str, int len) {
        boolean flag = true;
        int s = 0;
        int e = len - 1;
        while (s < e) {
            char leftCh = str.charAt(s);
            char rightCh = str.charAt(e);
            if (leftCh == rightCh) {
                s++;
                e--;
            } else {
                if (flag == false)
                    return false;
                flag = false;
                if (str.charAt(e - 1) == leftCh && str.charAt(s + 1) == rightCh)
                    return doubleCheck(str, len, s, e);
                else if (str.charAt(e - 1) == leftCh)
                    e--;
                else if (str.charAt(s + 1) == rightCh)
                    s++;
            }
        }
        return true;
    }

    public static boolean doubleCheck(String str, int len, int s, int e) {
        int new_s = s + 1;
        int new_e = e - 1;
        int flag = 0;
        while (new_s < e) {
            char leftCh = str.charAt(new_s);
            char rightCh = str.charAt(e);
            if (leftCh == rightCh) {
                new_s++;
                e--;
            } else {
                flag++;
                break;
            }
        }

        while (s < new_e) {
            char leftCh = str.charAt(s);
            char rightCh = str.charAt(new_e);
            if (leftCh == rightCh) {
                s++;
                new_e--;
            } else {
                flag++;
                break;
            }
        }
        if (flag == 2)
            return false;
        return true;
    }
}