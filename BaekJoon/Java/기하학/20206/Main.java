import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        int[] pos = new int[3];
        pos[0] = Integer.parseInt(in[0]);
        pos[1] = Integer.parseInt(in[1]);
        pos[2] = Integer.parseInt(in[2]);

        int[] square = new int[4];
        in = br.readLine().split(" ");
        square[0] = Integer.parseInt(in[0]);
        square[1] = Integer.parseInt(in[1]);
        square[2] = Integer.parseInt(in[2]);
        square[3] = Integer.parseInt(in[3]);

        System.out.println(solution(pos, square));
        br.close();
    }

    public static String solution(int[] pos, int[] square) {
        int a = pos[0];
        int b = pos[1];
        int c = pos[2];

        int x1 = square[0], x2 = square[1];
        int y1 = square[2], y2 = square[3];

        if (a == 0) { // x축에 평행
            if (b < 0)
                c = -c;
            if (y1 < c && c < y2)
                return "Poor";
            return "Lucky";
        } else if (b == 0) { // y축에 수직
            if (a < 0)
                c = -c;
            if (x1 < c && c < x2)
                return "Poor";
            return "Lucky";
        }
        // 기울기가 음수
        if (a * b > 0) {
            int v1 = (a * x1 + b * y1);
            int v2 = (a * x2 + b * y2);
            v1 = -v1;
            v2 = -v2;
            int max = Math.max(v1, v2);
            int min = Math.min(v1, v2);
            if (min < c && c < max)
                return "Poor";
        }
        // 기울기가 양수
        else if (a * b < 0) {
            int v1 = (a * x2 + b * y1);
            int v2 = (a * x1 + b * y2);
            v1 = -v1;
            v2 = -v2;
            int max = Math.max(v1, v2);
            int min = Math.min(v1, v2);
            if (min < c && c < max)
                return "Poor";
        }
        return "Lucky";
    }
}