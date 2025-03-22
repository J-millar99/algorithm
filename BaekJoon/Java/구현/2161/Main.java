import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= num; i++) {
            q.add(i);
        }

        while (q.size() != 1) {
            sb.append(q.poll()).append(" ");
            int e = q.poll();
            q.add(e);
        }
        sb.append(q.poll());
        System.out.println(sb);
        br.close();
    }
}