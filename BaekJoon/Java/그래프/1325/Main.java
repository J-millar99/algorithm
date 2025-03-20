import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<List<Integer>> array;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);

        array = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            array.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            in = br.readLine().split(" ");
            int node1 = Integer.parseInt(in[0]);
            int node2 = Integer.parseInt(in[1]);
            array.get(node2).add(node1);
        }

        int max = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            boolean[] visit = new boolean[n + 1];
            count = 0;
            dfs(array, visit, i);
            // bfs(array, visit, i);
            if (max < count) {
                max = count;
                result = new ArrayList<>();
                result.add(i);
            }
            else if (max == count) {
                result.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Integer integer : result) {
            sb.append(integer).append(" ");
        }
        System.out.println(sb);
        br.close();
    }

    public static void bfs(List<List<Integer>> array, boolean[] visit, int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visit[start] = true;
        while (!q.isEmpty()) {
            int index = q.poll();
            for (Integer idx : array.get(index)) {
                if (!visit[idx]) {
                    q.add(idx);
                    visit[idx] = true;
                    count++;
                }
            }
        }
    }

    public static void dfs(List<List<Integer>> array, boolean[] visit, int start) {
        visit[start] = true;
        for (Integer idx : array.get(start)) {
            if (!visit[idx]) {
                count++;
                dfs(array, visit, idx);
            }
        }
    }
}
