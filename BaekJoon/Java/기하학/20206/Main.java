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
        int A = pos[0];
        int B = pos[1];
        int C = pos[2];
        
        int x1 = square[0], x2 = square[1];
        int y1 = square[2], y2 = square[3];
        
        // 사각형의 네 꼭짓점에 대해 직선 방정식의 값 계산
        long v1 = (long)A * x1 + (long)B * y1 + C;
        long v2 = (long)A * x1 + (long)B * y2 + C;
        long v3 = (long)A * x2 + (long)B * y1 + C;
        long v4 = (long)A * x2 + (long)B * y2 + C;
        
        // 0이 아닌 값들이 모두 같은 부호인지 확인
        boolean allPositive = true;
        boolean allNegative = true;
        
        // 각 꼭짓점 값을 검사
        if (v1 > 0 || (v1 == 0 && (v2 > 0 || v3 > 0 || v4 > 0))) allNegative = false;
        if (v1 < 0 || (v1 == 0 && (v2 < 0 || v3 < 0 || v4 < 0))) allPositive = false;
        
        if (v2 > 0 || (v2 == 0 && (v1 > 0 || v3 > 0 || v4 > 0))) allNegative = false;
        if (v2 < 0 || (v2 == 0 && (v1 < 0 || v3 < 0 || v4 < 0))) allPositive = false;
        
        if (v3 > 0 || (v3 == 0 && (v1 > 0 || v2 > 0 || v4 > 0))) allNegative = false;
        if (v3 < 0 || (v3 == 0 && (v1 < 0 || v2 < 0 || v4 < 0))) allPositive = false;
        
        if (v4 > 0 || (v4 == 0 && (v1 > 0 || v2 > 0 || v3 > 0))) allNegative = false;
        if (v4 < 0 || (v4 == 0 && (v1 < 0 || v2 < 0 || v3 < 0))) allPositive = false;
        
        // 단 하나의 꼭짓점만 직선 위에 있고 나머지는 같은 쪽에 있는 경우도 Lucky
        return (allPositive || allNegative) ? "Lucky" : "Poor";
    }
}