import java.io.*;
import java.util.*;

public class Main {
    static Deque<Integer> dq = new ArrayDeque<>();
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);

        in = br.readLine().split(" ");
        int[] arr = new int[m];

        for (int i = 0; i < m; i++) 
            arr[i] = Integer.parseInt(in[i]);
        
        
        for (int i = 0; i < n; i++) 
            dq.add(i + 1);
        
        for (int e : arr) {
            minRotateCount(e);
            dq.poll();
        }

        System.out.println(answer);
        br.close();
    }

    public static void rotateRight(Deque<Integer> dq) {
        dq.addFirst(dq.pollLast());
    }

    public static void rotateLeft(Deque<Integer> dq) {
        dq.addLast(dq.pollFirst());
    }

    public static void minRotateCount(int e) {
        if (dq.peek() == e)
            return;

        Deque<Integer> ldq = new ArrayDeque<>(dq);
        Deque<Integer> rdq = new ArrayDeque<>(dq);

        int lcnt = 0, rcnt = 0;

        while (ldq.peek() != e) {
            rotateLeft(ldq);
            lcnt++;
        }

        while (rdq.peek() != e) {
            rotateRight(rdq);
            rcnt++;
        }

        if (lcnt > rcnt) {
            answer += rcnt;
            while (rcnt != 0) {
                rotateRight(dq);
                rcnt--;
            }
        } else {
            answer += lcnt;
            while (lcnt != 0) {
                rotateLeft(dq);
                lcnt--;
            }
        }
    }
}
