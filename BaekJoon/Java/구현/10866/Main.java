import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            if (input[0].equals("push_front")) {
                q.addFirst(Integer.parseInt(input[1]));
            } else if (input[0].equals("push_back")) {
                q.addLast(Integer.parseInt(input[1]));
            } else if (input[0].equals("pop_front")) {
                if (q.isEmpty())
                    sb.append("-1");
                else
                    sb.append(q.pollFirst());
                sb.append("\n");
            } else if (input[0].equals("pop_back")) {
                if (q.isEmpty())
                    sb.append("-1");
                else
                    sb.append(q.pollLast());
                sb.append("\n");
            } else if (input[0].equals("size")) {
                sb.append(q.size()).append("\n");
            } else if (input[0].equals("empty")) {
                sb.append(q.isEmpty() ? "1" : "0").append("\n");  
            } else if (input[0].equals("front")) {
                if (q.isEmpty())
                    sb.append("-1");
                else
                    sb.append(q.peekFirst());
                sb.append("\n");
            } else if (input[0].equals("back")) {
                if (q.isEmpty())
                    sb.append("-1");
                else
                    sb.append(q.peekLast());
                sb.append("\n");
            }
        }
        System.out.println(sb);
        br.close();
    }
}
