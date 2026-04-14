import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tries = Integer.parseInt(br.readLine());

        for (int cnt = 0; cnt < tries; cnt++) {
            String[] in = br.readLine().split(" ");

            // 건물 개수, 건설규칙 총 개수
            int n = Integer.parseInt(in[0]);
            int k = Integer.parseInt(in[1]);

            in = br.readLine().split(" ");
            int[] buildCost = new int[n + 1];
            for (int i = 0; i < n; i++)
                buildCost[i + 1] = Integer.parseInt(in[i]);

            List<List<Integer>> adj = new ArrayList<>();
            int[] inDegree = new int[n + 1];
            for (int i = 0; i <= n; i++)
                adj.add(new ArrayList<>());

            for (int i = 0; i < k; i++) {
                in = br.readLine().split(" ");
                int from = Integer.parseInt(in[0]);
                int to = Integer.parseInt(in[1]);
                adj.get(from).add(to);
                inDegree[to]++;
            }

            int winCondition = Integer.parseInt(br.readLine());

            int[] dp = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                dp[i] = buildCost[i];
            }
    
            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i <= n; i++)
                if (inDegree[i] == 0)
                    q.offer(i);

            while(!q.isEmpty()) {
                int current = q.poll();

                for (int neighbor : adj.get(current)) {
                    dp[neighbor] = Math.max(dp[neighbor], dp[current] + buildCost[neighbor]);
                    inDegree[neighbor]--;
                    if (inDegree[neighbor] == 0)
                        q.offer(neighbor);
                }
            }
            sb.append(dp[winCondition]).append("\n");
        }
        br.close();
        System.out.print(sb);
    }    
}
