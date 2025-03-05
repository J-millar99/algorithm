import java.io.*;
import java.util.*;

public class Main {
    static Deque<Integer> dq = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        for (int i = 1; i <= n; i++)
            dq.add(i);

        input = br.readLine().split(" ");
        int[] arr = new int[m];

        for (int i = 0; i < m; i++)
            arr[i] = Integer.parseInt(input[i]);
        
        int total = 0;
        for (int i : arr) {
            int rcost = rotateRight(i);
            int lcost = rotateLeft(i);
            int min = Math.min(rcost, lcost);
            total += min;
            if (min == rcost)
                removeRight(i);
            else
                removeLeft(i);
        }
        System.out.println(total);
        br.close();
    }

    public static int rotateRight(int find) {
        Deque<Integer> copied = new ArrayDeque<>(dq);
        int count = 0;
        int temp = copied.pollFirst();
        while (temp != find) {
            copied.addLast(temp);
            temp = copied.pollFirst();
            ++count;
        }
        return count;
    }

    public static int rotateLeft(int find) {
        Deque<Integer> copied = new ArrayDeque<>(dq);
        int count = 0;
        int temp = copied.pollLast();
        while (temp != find) {
            copied.addFirst(temp);
            temp = copied.pollLast();
            ++count;
        }
        return count + 1;
    }

    public static void removeLeft(int find) {
        int temp = dq.pollLast();
        while (temp != find) {
            dq.addFirst(temp);
            temp = dq.pollLast();
        }
    }

    public static void removeRight(int find) {
        int temp = dq.pollFirst();
        while (temp != find) {
            dq.addLast(temp);
            temp = dq.pollFirst();
        }
    }
}
