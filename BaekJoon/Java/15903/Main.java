import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        int num = Integer.parseInt(in[0]);
        int tries = Integer.parseInt(in[1]);

        Queue<Long> pq = new PriorityQueue<>();
        in = br.readLine().split(" ");
        for (int i = 1; i <= num; i++) {
            pq.add(Long.parseLong(in[i - 1]));
        }

        for (int i = 0; i < tries; i++) {
            Long n1 = pq.poll();
            Long n2 = pq.poll();
            Long sum = n1 + n2;
            pq.add(sum);
            pq.add(sum);
        }
        
        long total = 0;
        for (long integer : pq) {
            total += integer;
        }
        System.out.println(total);
        br.close();
    }
}