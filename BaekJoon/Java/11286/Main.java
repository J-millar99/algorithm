import java.io.*;
import java.util.*;

public class Main {
    static PriorityQueue<Integer> pQ = new PriorityQueue<>(); // 양수 -> 최소 힙: 절댓값 힙
    static PriorityQueue<Integer> nQ = new PriorityQueue<>(); // 음수 -> 최대 힙: 절댓값 힙
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int cmd = Integer.parseInt(br.readLine());
            
            if (cmd > 0)
                pQ.add(cmd);
            else if (cmd < 0)
                nQ.add(cmd * -1);
            else {
                if (pQ.isEmpty() && nQ.isEmpty())
                    sb.append("0");
                else if (pQ.isEmpty())
                    sb.append(nQ.poll() * -1);
                else if (nQ.isEmpty())
                    sb.append(pQ.poll());
                else {
                    cmd = pQ.peek() >= nQ.peek() ? nQ.poll() * -1 : pQ.poll();
                    sb.append(cmd);
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }
}
