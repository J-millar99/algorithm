import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]); // 보석 개수
        int k = Integer.parseInt(in[1]); // 가방 개수

        int[][] jewel = new int[n][2];
        for (int i = 0; i < n; i++) {
            in = br.readLine().split(" ");
            jewel[i][0] = Integer.parseInt(in[0]); // 무게
            jewel[i][1] = Integer.parseInt(in[1]); // 가치
        }
        Arrays.sort(jewel, (a, b) -> Integer.compare(a[0], b[0]));

        // 가방 입력
        int[] bag = new int[k];
        for (int i = 0; i < k; i++) 
            bag[i] = Integer.parseInt(br.readLine());
        Arrays.sort(bag);
        
        long total = 0;
        int j = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            int size = bag[i];

            while (j < n && jewel[j][0] <= size) {
                pq.add(jewel[j][1] * -1);
                j++;
            }

            if (!pq.isEmpty())
                total += pq.poll() * -1;
        }
  
        System.out.println(total);
        br.close();
    }
}