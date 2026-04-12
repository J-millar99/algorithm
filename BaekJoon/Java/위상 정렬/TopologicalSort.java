import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 백준 2252: 줄세우기 예시
public class TopologicalSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m;

        String[] in = br.readLine().split(" ");
        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);
        
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            in = br.readLine().split(" ");
            int from = Integer.parseInt(in[0]);
            int to = Integer.parseInt(in[1]);
            adj.get(from).add(to);
            inDegree[to]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0)
                q.offer(i);
        }

        List<Integer> sortedOrder = new ArrayList<>();
        while (!q.isEmpty()) {
            int currentNode = q.poll();
            sortedOrder.add(currentNode);

            for (Integer neighbor : adj.get(currentNode)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0)
                    q.offer(neighbor);
            }
        }
        // 사이클 감지
        // if (sortedOrder.size() != n) {
            // System.out.println("사이클");
        // }

        StringBuilder sb =  new StringBuilder();
        for (Integer integer : sortedOrder) {
            sb.append(integer).append(" ");
        }
        System.out.println(sb);
    }    
}
