import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tries = Integer.parseInt(br.readLine());
        for (int i = 0; i < tries; i++) {
            String input = br.readLine();
            if (isVPS(input))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        br.close();
    }

    public static boolean isVPS(String str) {
        Stack<Character> s = new Stack<>();
        for (Character ch : str.toCharArray()) {
            if (ch == '(')
                s.add(ch);
            else if (ch == ')') {
                if (!s.empty())
                    s.pop();
                else
                    return false;
            }
        }
        return s.empty();
    }
}
