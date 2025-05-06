import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        // A행렬 입력
        String[] in = br.readLine().split(" ");

        int n1 = Integer.parseInt(in[0]);
        int m1 = Integer.parseInt(in[1]);

        int[][] a = new int[n1][m1];
        for (int i = 0; i < n1; i++) {
            in = br.readLine().split(" ");
            for (int j = 0; j < m1; j++) {
                a[i][j] = Integer.parseInt(in[j]);
            }
        }

        // B행렬 입력
        in = br.readLine().split(" ");
        int n2 = Integer.parseInt(in[0]);
        int m2 = Integer.parseInt(in[1]);

        int[][] b = new int[n2][m2];
        for (int i = 0; i < n2; i++) {
            in = br.readLine().split(" ");
            for (int j = 0; j < m2; j++) {
                b[i][j] = Integer.parseInt(in[j]);
            }
        }

        // A B행렬을 곱셈
        int[][] result = new int[n1][m2];

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m2; j++) {
                for (int k = 0; k < m1; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}