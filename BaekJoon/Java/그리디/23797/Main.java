import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String in = br.readLine();
        int k = 1, p = 1;
        int cnt = 0;
        char prev = in.charAt(0);
        System.out.print(k);
        for (int i = 1; i < in.length(); i++) {
            char ch = in.charAt(i);
            if (ch == 'K') {
                if (prev == ch)
                    k++;
                else
                    k = p;
            } else if (ch == 'P') {
                if (prev == ch)
                    p++;
                else
                    p = k;
            }
            cnt = Math.max(cnt, p);
            cnt = Math.max(cnt, k);
            if (ch == 'K')
                System.out.print(k);
            else if (ch == 'P')
                System.out.print(p);
            if (p == k) {
                if (ch == 'K')
                    k--;
                else if (ch == 'P')
                    p--;
            }
            prev = ch;
        }
        System.out.println(cnt);
        br.close();
    }
}