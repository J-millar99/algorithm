import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        int[] inDegree = new int[n + 1];
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

        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        while(!q.isEmpty()) {
            Integer current = q.poll();

            for (Integer neighbor : adj.get(current)) {
                inDegree[neighbor]--;
                dp[neighbor] = Math.max(dp[neighbor], dp[current] + 1);
                if (inDegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }
        br.close();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) 
            sb.append(dp[i]).append(" ");
        System.out.println(sb);
    }    
}
