import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < num; i++) {
            String[] in = br.readLine().split(" ");
            for (int j = 0; j < num; j++) {
                pq.add(-Integer.parseInt(in[j]));
            }
        }
        int result = 0;
        for (int i = 0; i < num; i++) {
            result = -pq.poll();
        }
        System.out.print(result);
        br.close();
    }
}