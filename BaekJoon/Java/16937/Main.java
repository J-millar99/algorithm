import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int h, w;
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        h = Integer.parseInt(in[0]);
        w = Integer.parseInt(in[1]);

        int num = Integer.parseInt(br.readLine());
        int[][] squares = new int[num][2];
        for (int i = 0; i < num; i++) {
            in = br.readLine().split(" ");
            int r = Integer.parseInt(in[0]);
            int c = Integer.parseInt(in[1]);
            squares[i][0] = r;
            squares[i][1] = c;
        }
        solution(squares, num);
        br.close();
    }

    public static void solution(int[][] squares, int num) {
        int maxArea = 0;
        for (int i = 0; i < num - 1; i++) {
            for (int j = i + 1; j < num; j++) {
                int r1 = squares[i][0];
                int c1 = squares[i][1];
                int r2 = squares[j][0];
                int c2 = squares[j][1];
                if (stickerInField(r1, c1, r2, c2))
                    maxArea = Math.max(maxArea, r1 * c1 + r2 * c2);
            }
        }
        System.out.println(maxArea);
    }

    public static boolean stickerInField(int r1, int c1, int r2, int c2) {
        // 모양 그대로 가로 붙이기
        if (r1 + r2 <= w && c1 <= h && c2 <= h)
            return true;
        // 모양 그대로 세로 붙이기
        if (c1 + c2 <= h && r1 <= w && r2 <= w)
            return true;
        // 두 번째 도형을 회전하여 가로 붙이기
        if (r1 + c2 <= w && c1 <= h && r2 <= h)
            return true;
        // 두 번째 도형을 회전하여 세로 붙이기
        if (c1 + r2 <= h && r1 <= w && c2 <= w)
            return true;

        // 첫 번째 도형을 회전하여 그대로 가로 붙이기
        if (c1 + r2 <= w && r1 <= h && c2 <= h)
            return true;
        // 첫 번째 도형을 회전하여 그대로 세로 붙이기
        if (r1 + c2 <= h && c1 <= w && r2 <= w)
            return true;
        // 둘다 도형을 회전하여 가로 붙이기
        if (c1 + c2 <= w && r1 <= h && r2 <= h)
            return true;
        // 둘다 도형을 회전하여 세로 붙이기
        if (r1 + r2 <= h && c1 <= w && c2 <= w)
            return true;
        return false;
    }
}