import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] node;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);
        node = new int[m + 1];

        backTracking(1, 1);
        System.out.print(sb);
        br.close();
    }

    public static void backTracking(int start, int depth) {
        if (depth == m + 1) {
            for (int i = 1; i <= m; i++) {
                sb.append(node[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            node[depth] = i;
            backTracking(i, depth + 1);
        }
    }
}
