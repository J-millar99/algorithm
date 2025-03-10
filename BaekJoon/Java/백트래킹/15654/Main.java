import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<Integer> list = new ArrayList<>();
    static boolean[] visit;
    static int[] node;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");
        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);
        visit = new boolean[n + 1];
        node = new int[m + 1];

        in = br.readLine().split(" ");
        for (int i = 0; i < in.length; i++) {
            list.add(Integer.parseInt(in[i]));
        }

        list.sort(null);
        backTracking(1);
        System.out.print(sb);
        br.close();
    }

    public static void backTracking(int start) {
        if(start == m + 1) {
            for (int i = 1; i <= m; i++) {
                sb.append(node[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visit[i] == false) {
                node[start] = list.get(i - 1);
                visit[i] = true;
                backTracking(start + 1);
                visit[i] = false;
            }
        }
    }
}
