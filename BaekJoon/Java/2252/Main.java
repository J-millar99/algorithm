import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);

        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }

        int[] deg = new int[n + 1];
        for (int i = 0; i < m; i++) {
            in = br.readLine().split(" ");
            int a = Integer.parseInt(in[0]);
            int b = Integer.parseInt(in[1]);
            arr.get(a).add(b);
            deg[b]++;
        }

        solution(arr, deg);
        System.out.print(sb);
        br.close();
    }

    public static void solution(List<List<Integer>> arr, int[] deg) {
        Queue<Integer> q = new ArrayDeque<>();
        // q를 순회하며 deg가 0인 노드 번호만 넣는다
        for (int i = 1; i < arr.size(); i++) {
            if (deg[i] == 0)
                q.add(i);
        }

        // q에서 노드(deg == 0)를 뽑고 기록, 그 노드에 연결된 노드들의 deg를 줄이며 deg가 0이 되었을 때 큐에 넣는다
        while (!q.isEmpty()) {
            int node = q.poll();
            sb.append(node).append(" ");
            for (int conn : arr.get(node)) {
                deg[conn]--;
                if (deg[conn] == 0)
                    q.add(conn);
            }
        }
    }
}