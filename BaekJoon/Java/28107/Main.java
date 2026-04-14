import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);
        int[] ret = new int[n];

        Map<Integer, PriorityQueue<Integer>> arr = new HashMap<>();
        for (int i = 0; i < n; i++) {
            in = br.readLine().split(" ");
            int size = Integer.parseInt(in[0]);
            for (int j = 1; j <= size; j++) {
                int key = Integer.parseInt(in[j]);
                if (arr.containsKey(key)) {
                    arr.get(key).add(i + 1);
                } else {
                    PriorityQueue<Integer> pq = new PriorityQueue<>();
                    pq.add(i + 1);
                    arr.put(key, pq);
                }
            }
        }

        in = br.readLine().split(" ");
        int[] q = new int[m];
        for (int i = 0; i < m; i++) 
            q[i] = Integer.parseInt(in[i]);

        for (int i = 0; i < m; i++) {
            int s = q[i];
            if (!arr.containsKey(s))
                continue;
            Integer idx = arr.get(s).poll();
            if (idx == null)
                continue;
            ret[idx - 1]++;
        }
        
        for (int i = 0; i < n; i++) 
            sb.append(ret[i] + " ");
        System.out.println(sb);
        br.close();
    }
}