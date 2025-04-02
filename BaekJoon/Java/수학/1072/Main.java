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
        // 소수점 3자리 이하 손실, 그러나 정수 연산만 하므로 정확도 보장
        int result = (int) ((long) y * 100 / x);
        // 소수점을 손실하지 않지만 정확도에 오차가 존재
        // int result = (int) (((double) y / (double) x) * 100);
        return result;
    }
}