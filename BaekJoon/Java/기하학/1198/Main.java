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

        double maxArea = 0;
        for (int i = 0; i < num - 2; i++) {
            for (int j = i + 1; j < num - 1; j++) {
                for (int k = j + 1; k < num; k++) {
                    maxArea = Math.max(maxArea, triangleArea(c[i][0], c[i][1], c[j][0], c[j][1], c[k][0], c[k][1]));
                }
            }
        }
        br.close();
    }

    public static double triangleArea(double x1, double y1, double x2, double y2, double x3, double y3) {
        double area = 0.5 * Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)));
        return area;
    }
}