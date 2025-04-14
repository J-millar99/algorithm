import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        double[][] c = new double[num][2];
        for (int i = 0; i < num; i++) {
            String[] in = br.readLine().split(" ");
            c[i][0] = Double.parseDouble(in[0]);
            c[i][1] = Double.parseDouble(in[1]);
        }

        int count = 0;
        for (int i = 0; i < num - 2; i++) {
            for (int j = i + 1; j < num - 1; j++) {
                for (int k = j + 1; k < num; k++) {
                    if(triangle(c[i][0], c[i][1], c[j][0], c[j][1], c[k][0], c[k][1]))
                        count++;
                }
            }
        }
        System.out.println(count);
        br.close();
    }

    public static boolean triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        // x좌표가 같은 경우를 확인
        boolean p1p2SameX = x1 == x2;
        boolean p1p3SameX = x1 == x3;
        boolean p2p3SameX = x2 == x3;
        
        // y좌표가 같은 경우를 확인
        boolean p1p2SameY = y1 == y2;
        boolean p1p3SameY = y1 == y3;
        boolean p2p3SameY = y2 == y3;
        
        // 조건 1: p1과 p2가 같은 x좌표를 가지고, p1과 p3가 같은 y좌표를 가지는 경우
        if (p1p2SameX && p1p3SameY) {
            return true;
        }
        // 조건 2: p1과 p2가 같은 x좌표를 가지고, p2와 p3가 같은 y좌표를 가지는 경우
        else if (p1p2SameX && p2p3SameY) {
            return true;
        }
        // 조건 3: p1과 p3가 같은 x좌표를 가지고, p1과 p2가 같은 y좌표를 가지는 경우
        else if (p1p3SameX && p1p2SameY) {
            return true;
        }
        // 조건 4: p1과 p3가 같은 x좌표를 가지고, p2와 p3가 같은 y좌표를 가지는 경우
        else if (p1p3SameX && p2p3SameY) {
            return true;
        }
        // 조건 5: p2와 p3가 같은 x좌표를 가지고, p1과 p2가 같은 y좌표를 가지는 경우
        else if (p2p3SameX && p1p2SameY) {
            return true;
        }
        // 조건 6: p2와 p3가 같은 x좌표를 가지고, p1과 p3가 같은 y좌표를 가지는 경우
        else if (p2p3SameX && p1p3SameY) {
            return true;
        }
        
        // 위 조건 중 하나도 만족하지 않으면 직각삼각형이 아님
        return false;
    }
}