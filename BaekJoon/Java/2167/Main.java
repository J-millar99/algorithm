import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        int row = Integer.parseInt(in[0]);
        int col = Integer.parseInt(in[1]);

        int[][] arr = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            in = br.readLine().split(" ");
            for (int j = 1; j <= col; j++) {
                arr[i][j] = arr[i][j - 1] + Integer.parseInt(in[j - 1]);
            }
        }

        // for (int i = 0; i <= row; i++) {
        //     for (int j = 0; j <= col; j++) {
        //         System.out.print(arr[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        int tries = Integer.parseInt(br.readLine());
        for (int i = 0; i < tries; i++) {
            in = br.readLine().split(" ");
            int x1 = Integer.parseInt(in[0]);
            int y1 = Integer.parseInt(in[1]);
            int x2 = Integer.parseInt(in[2]);
            int y2 = Integer.parseInt(in[3]);
            int sum = 0;
            for (int r = x2; r >= x1; r--) {
                sum += arr[r][y2] - arr[r][y1 - 1];
            }
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}