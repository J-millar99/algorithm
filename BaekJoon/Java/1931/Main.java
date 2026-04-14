import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1])
                return Integer.compare(a[1], b[1]);
            else
                return Integer.compare(a[0], b[0]);
        });

        for (int i = 0; i < num; i++) {
            String[] in = br.readLine().split(" ");
            int start = Integer.parseInt(in[0]);
            int end = Integer.parseInt(in[1]);
            pq.add(new int[]{start, end});
        }

        int time = 0;
        int count = 0;
        while (!pq.isEmpty()) {
            int[] schedule = pq.poll();
            if (schedule[0] < time)
                continue;
            count++;
            time = schedule[1];
        }

        System.out.println(count);
        br.close();
    }
}