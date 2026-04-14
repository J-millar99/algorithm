import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tries = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 0; i < tries; i++) {
            String str = br.readLine();
            count += solution(str);
        }

        System.out.println(count);
        br.close();
    }

    public static int solution(String str) {
        Stack<Character> st = new Stack<>();

        for (Character ch : str.toCharArray()) {
            if (st.isEmpty())
                st.add(ch);
            else {
                if (ch == st.peek())
                    st.pop();
                else
                    st.add(ch);
            }
        }
        if (st.isEmpty())
            return 1;
        return 0;
    }
}
