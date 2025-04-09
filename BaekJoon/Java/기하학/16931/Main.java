import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);
        
        int[][] field = new int[n][m];
        for (int i = 0; i < n; i++) {
            in = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                field[i][j] = Integer.parseInt(in[j]);
            }
        }
        solution(field, n, m);
        br.close();
    }
 
    public static void solution(int[][] field, int row, int col) {
        int top = 0;
        int bottom = 0;
        int[] side = new int[4];
        
    }
}