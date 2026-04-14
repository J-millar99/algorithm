import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        String[] in;
        long [][] pos = new long[n + 1][3];
        for (int i = 1; i <= n; i++) {
            in = br.readLine().split(" ");
            pos[i][1] = Integer.parseInt(in[0]);
            pos[i][2] = Integer.parseInt(in[1]);
        }
        System.out.println(String.format("%.1f", solution(n, pos)));
        br.close();
    }

    public static double solution(int n, long[][] pos) {
        long ret = 0;
        for (int i = 1; i <= n; i++) {
            int k = i + 1;
            if (k > n)
                k = 1;
            ret += pos[i][1] * pos[k][2] - pos[k][1] * pos[i][2];
        }
        ret = Math.abs(ret);
        return (double) ret / 2;
    }
}