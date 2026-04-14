import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int area = 0;
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);
        
        int[][] field1 = new int[n][m];
        int[][] field2 = new int[m][n];
        for (int i = 0; i < n; i++) {
            in = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                field1[i][j] = Integer.parseInt(in[j]);
                field2[j][i] = Integer.parseInt(in[j]);
            }
        }
        // 블럭은 반드시 한 개 이상 놓여있음
        // top, bottom의 겉넓이는 n x m
        area = n * m * 2;
        solution(field1, n, m);
        solution(field2, m, n);
        System.out.println(area);
        br.close();
    }
 
    public static void solution(int[][] field, int row, int col) {
        for (int i = 0; i < row; i++) {
            int block = field[i][0];
            area += block;
            for (int j = 1; j < col; j++) {
                int next = field[i][j];
                area += Math.abs(block - next);
                block = next;
            }
        }
        for (int i = 0; i < row; i++) {
            area += field[i][col - 1];
        }
    }
}