import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static Stack<Integer> st;
    static int next;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[] arr = new int[num];
        for (int i = 0; i < num; i++)
            arr[i] = Integer.parseInt(br.readLine());

        st = new Stack<>();
        next = 1;
        for (int target : arr) {
            if (st.isEmpty()) {
                push(target);
                continue;
            }
            int top = st.peek();
            if (top != target) {
                if (top > target) {
                    sb.setLength(0);
                    sb.append("NO\n");
                    break;
                }
                push(target);
            } else if (top == target)
                pop();
        }
        System.out.print(sb);
        br.close();
    }

    public static void push(int target) {
        while (next <= target) {
            st.add(next++);
            sb.append("+\n");
        }
        pop();
    }

    public static void pop() {
        st.pop();
        sb.append("-\n");
    }

}
