import java.util.Stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tries = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < tries; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String cmd = st.nextToken();
            if (cmd.equals("push")) {
                int value = Integer.parseInt(st.nextToken());
                stack.push(value);
            } else if (cmd.equals("pop")) {
                if (stack.isEmpty())
                    System.out.println("-1");
                else
                    System.out.println(stack.pop());
            } else if (cmd.equals("size")) {
                System.out.println(stack.size());
            } else if (cmd.equals("empty")) {
                if (stack.isEmpty())
                    System.out.println("1");
                else
                    System.out.println("0");
            } else if (cmd.equals("top")) {
                if (stack.isEmpty())
                    System.out.println("-1");
                else
                    System.out.println(stack.peek());        
            }
        }
    }
}