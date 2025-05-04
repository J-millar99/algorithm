import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        String in = br.readLine();
        int len = in.length();
        int s = 0, e = 0;

        while (true) {
            char ch = in.charAt(e);
            if (ch == 'X')
                e++;
            else if (ch == '.') {
                if (e - s == 2)
                    addTwoB();
                else if (s != e) {
                    impossible();
                    break;
                }
                sb.append('.');
                e++;
                s = e;
            }
            if (e - s == 4) {
                addFourA();
                s = e;
            }
            if (e == len) {
                if (e - s == 2)
                    addTwoB();
                else if (e != s)
                    impossible();
                break;
            }
        }
        System.out.print(sb);
        br.close();
    }

    public static void addFourA() {
        for (int i = 0; i < 4; i++) {
            sb.append('A');
        }
    }

    public static void addTwoB() {
        for (int i = 0; i < 2; i++) {
            sb.append('B');
        }
    }

    public static void impossible() {
        sb.setLength(0);
        sb.append(-1);
    }
}