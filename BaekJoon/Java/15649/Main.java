import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        boolean[] visit = new boolean[n];
        int[] node = new int[m];

        backTracking(node, visit, 0);
        System.out.print(sb);
        br.close();
    }

    public static void backTracking(int[] node, boolean[] visit, int k) {
        if (k == m) {
            int i;
            for (i = 0; i < m; i++)
                sb.append(node[i]).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visit[i] == false) {
                node[k] = i + 1;
                visit[i] = true;
                backTracking(node, visit, k + 1);
                visit[i] = false;
            }
        }
    }
}