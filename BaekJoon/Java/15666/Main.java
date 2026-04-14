import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<Integer> list = new ArrayList<>();
    static int[] node;
    static LinkedHashSet<String> set = new LinkedHashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");
        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);
        node = new int[m + 1];

        in = br.readLine().split(" ");
        for (int i = 0; i < in.length; i++) {
            list.add(Integer.parseInt(in[i]));
        }

        list.sort(null);
        backTracking(1, 1);

        StringBuilder sb = new StringBuilder();
        for (String string : set) {
            sb.append(string);
        }
        System.out.print(sb);
        br.close();
    }

    public static void backTracking(int start, int depth) {
        if(depth == m + 1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= m; i++) {
                sb.append(node[i]).append(" ");
            }
            sb.append("\n");
            set.add(sb.toString());
            return;
        }

        for (int i = start; i <= n; i++) {
            node[depth] = list.get(i - 1);
            backTracking(i, depth + 1);
        }
    }
}
