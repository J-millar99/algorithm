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
        String[] in = br.readLine().split(" ");

        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list.add(new ArrayList<>());
            in = br.readLine().split(" ");
            int num = Integer.parseInt(in[0]);

            for (int j = 1; j <= num; j++) {
                list.get(i).add(Integer.parseInt(in[j]));
            }
        }
        
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) 
            adj.add(new ArrayList<>());
        int[] inDegree = new int[n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < list.get(i).size() - 1; j++) {
                int from = list.get(i).get(j);
                int to = list.get(i).get(j + 1);
                adj.get(from).add(to);
                inDegree[to]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0)
                q.offer(i);
        }
        br.close();
        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int current = q.poll();
            topo.add(current);

            for (Integer neighbor : adj.get(current)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }
        if (topo.size() != n) {
            System.out.println(0);
        }
        else {
            StringBuilder sb = new StringBuilder();
            for (Integer integer : topo) {
                sb.append(integer).append("\n");
            }
            System.out.print(sb);
        }
    }
}
