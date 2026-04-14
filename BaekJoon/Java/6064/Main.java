import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tries = Integer.parseInt(br.readLine());

        for (int i = 0; i < tries; i++) {
            String[] input = br.readLine().split(" ");
            int m = Integer.parseInt(input[0]);
            int n = Integer.parseInt(input[1]);
            int x = Integer.parseInt(input[2]);
            int y = Integer.parseInt(input[3]);

            solution(m, n, x, y);
        }
        System.out.print(sb);
        br.close();
    }

    public static void solution(int m, int n, int x, int y) {
        // 년도의 개수는 m * n의 최소 공배수
        while (x <= m * n) {
            if ((x - 1) % n + 1 == y) {
                sb.append(x).append("\n");
                return;
            }
            x += m;
        }
        sb.append("-1\n");
    }
}
