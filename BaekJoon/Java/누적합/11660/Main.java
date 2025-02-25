import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] arr2D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        arr2D = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 1; j <= n; j++)
                arr2D[i][j] = Integer.parseInt(line[j - 1]) + arr2D[i][j - 1] + arr2D[i - 1][j] - arr2D[i - 1][j - 1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            int x1 = Integer.parseInt(line[0]); int y1 = Integer.parseInt(line[1]);
            int x2 = Integer.parseInt(line[2]); int y2 = Integer.parseInt(line[3]);
            sb.append(rangeSum(x1, y1, x2, y2)).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    public static int rangeSum(int x1, int y1, int x2, int y2) {
        return arr2D[x2][y2] + arr2D[x1 - 1][y1 - 1] - arr2D[x1 - 1][y2] - arr2D[x2][y1 - 1];
    }
}