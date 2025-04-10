import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String s1 = br.readLine();
        String s2 = br.readLine();
        boolean flag = false;
        while (true) {
            int lastIdx = s2.length() - 1;
            if (s2.charAt(lastIdx) == 'A') {
                s2 = s2.substring(0, lastIdx);
            } else { // (s2.charAt(lastIdx) == 'B')
                s2 = s2.substring(0, lastIdx);
                s2 = new StringBuilder(s2).reverse().toString();
            }
            if (s1.length() == s2.length() && s1.equals(s2))
                flag = true;
            if (s1.length() > s2.length())
                break;
        }
        if (flag == true)
            System.out.println(1);
        else
            System.out.println(0);
        br.close();
    }
}