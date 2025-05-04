import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        String in = br.readLine();

        int len = in.length();
        char[] str = new char[len];

        int cnt = 0;
        boolean flag = false;
        for (int i = 0; i < len; i++) {
            char ch = in.charAt(i);
            if (ch == '.') {
                if (cnt != 0) {
                    flag = true;
                    break;
                }
                str[i] = '.';
            } else {
                cnt++;
                if (cnt == 2) {
                    str[i - 1] = str[i] = 'B';
                    cnt = 0;
                } else if (cnt == 4) {
                    str[i - 3] = str[i - 2] = str[i - 1] = str[i] = 'A';
                    cnt = 0;
                }
            }
        }

        if (flag == true)
            sb.append(-1);
        else
            for (char c : str)
                sb.append(c);
        System.out.print(sb);
        br.close();
    }
}