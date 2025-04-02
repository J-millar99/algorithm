import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        int x = Integer.parseInt(in[0]);
        int y = Integer.parseInt(in[1]);
        solution(x, y);
        br.close();
    }

    public static void solution(int x, int y) {
        int origin = getRate(x, y);
        int s = 0;
        int e = x;
        int result = 0;
        while (s <= e) {
            int m = (s + e) / 2;
            int z = getRate(x + m, y + m);
            if (origin == z) {
                result = m;
                s = m + 1;
            } else
                e = m - 1;
        }
        if (result == x)
            System.out.println(-1);
        else
            System.out.println(result + 1);
    }

    public static int getRate(int x, int y) {
        int result = (int) ((long) y * 100 / x);
        return result;
    }
}