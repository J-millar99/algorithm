import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        int ax = Integer.parseInt(in[0]), ay = Integer.parseInt(in[1]);
        int bx = Integer.parseInt(in[2]), by = Integer.parseInt(in[3]);
        int cx = Integer.parseInt(in[4]), cy = Integer.parseInt(in[5]);

        // 삼각형이 아니라면, 평행사변형이 될 수 없음
        if (!isNotTriangle(ax, ay, bx, by, cx, cy))
            System.out.println("-1.0");
        else
            System.out.println(solution(ax, ay, bx, by, cx, cy));
        br.close();
    }

    public static boolean isNotTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        if (0.5 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) == 0) // 면적이 0
            return false;
        return true;
    }

    public static double solution(int x1, int y1, int x2, int y2, int x3, int y3) {
        double arr[] = new double[3];
        arr[0] = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        arr[1] = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));
        arr[2] = Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2));
        double dmax = Arrays.stream(arr).max().orElse(Double.NaN);
        double dmin = Arrays.stream(arr).min().orElse(Double.NaN);
        return (dmax - dmin) * 2;
    }
}