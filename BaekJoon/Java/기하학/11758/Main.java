import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int x = 0;
    static final int y = 1;
    public static void main(String[] args) throws IOException {
        int[][] pos = new int[3][2];
        for (int i = 0; i < 3; i++) {
            String[] in = br.readLine().split(" ");
            pos[i][x] = Integer.parseInt(in[0]);   
            pos[i][y] = Integer.parseInt(in[1]);
        }

        int[] v1 = new int[2];
        int[] v2 = new int[2];

        // p1p2 = p2-p1
        v1[x] = pos[1][x] - pos[0][x];
        v1[y] = pos[1][y] - pos[0][y];

        // p2p3 = p3-p2
        v2[x] = pos[2][x] - pos[1][x];
        v2[y] = pos[2][y] - pos[1][y];

        int result = v1[x] * v2[y] - v1[y] * v2[x];
        if (result > 0)
            System.out.println(1);
        else if (result < 0)
            System.out.println(-1);
        else
            System.out.println(0);
        br.close();
    }
}