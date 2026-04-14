import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int[] line1 = new int[5];
        int[] line2 = new int[5];
        
        String[] in = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            line1[i + 1] = Integer.parseInt(in[i]);
        }

        in = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            line2[i + 1] = Integer.parseInt(in[i]);
        }

        if (isIntersect(line1, line2))
            System.out.println(1);
        else
            System.out.println(0);
        br.close();
    }

    public static boolean isIntersect(int[] line1, int[] line2) {
        int ccw1 = ccw(line1[1], line1[2], line1[3], line1[4], line2[1], line2[2]);
        int ccw2 = ccw(line1[1], line1[2], line1[3], line1[4], line2[3], line2[4]);
        int ccw3 = ccw(line2[1], line2[2], line2[3], line2[4], line1[1], line1[2]);
        int ccw4 = ccw(line2[1], line2[2], line2[3], line2[4], line1[3], line1[4]);
        
        // 두 선분이 일직선 상에 있는 경우를 처리
        if (ccw1 == 0 && ccw2 == 0 && ccw3 == 0 && ccw4 == 0) {
            return isOverlap(line1, line2);
        }
        
        // 일반적인 교차 판별
        return ccw1 * ccw2 <= 0 && ccw3 * ccw4 <= 0;
    }

    public static int ccw(int x1, int y1, int x2, int y2, int x3, int y3) {
        long result = (long)(x2 - x1) * (y3 - y1) - (long)(y2 - y1) * (x3 - x1);
        
        if (result > 0) return 1;       // 반시계 방향
        else if (result < 0) return -1; // 시계 방향
        else return 0;                  // 일직선
    }
    
    public static boolean isOverlap(int[] line1, int[] line2) {
        // x 좌표를 기준으로 정렬
        if (Math.max(line1[1], line1[3]) < Math.min(line2[1], line2[3]) || Math.max(line2[1], line2[3]) < Math.min(line1[1], line1[3])) {
            return false;
        }
        
        // y 좌표를 기준으로 정렬
        if (Math.max(line1[2], line1[4]) < Math.min(line2[2], line2[4]) || Math.max(line2[2], line2[4]) < Math.min(line1[2], line1[4])) {
            return false;
        }
        
        return true;
    }
}