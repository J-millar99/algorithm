import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        Stack<Character> st = new Stack<>();

        char temp = 0;
        int count = 0;
        for (Character ch : input.toCharArray()) {
            if (temp == '(' && ch == ')') {// lazer
                st.pop();
                count += st.size();
            }
            else if (ch == '(')
                st.add(ch);
            else if (ch == ')') {
                st.pop();
                count++;
            }
            temp = ch;
        }
        System.out.println(count);
        br.close();
    }
}
