import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int index = 0;
    public static void main(String[] args) throws IOException {
        while (true) {
            String in = br.readLine();
            if (in.charAt(0) == '-')
                break;
            solution(in);
        }
        System.out.print(sb);
        br.close();
    }

    public static void solution(String str) {
        index++;
        int len = str.length();
        int conv = 0;
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            if (ch == '{')
                st.add(ch);
            else if (ch == '}') {
                if (st.isEmpty()) {
                    st.add('{');
                    conv++;
                }
                else
                    st.pop();
            }
        }
        conv += st.size() / 2;
        sb.append(index + ". " + conv).append("\n");
    }
}