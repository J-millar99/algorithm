import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine();
            if (input.equals("."))
                break;
            solution(input);
        }
        System.out.print(sb);
        br.close();
    }

    public static void solution(String str) {
        Stack<Character> st = new Stack<>();
        for (char ch : str.toCharArray()) {
            // 여는 괄호인 경우 스택에 추가
            if (ch == '(' || ch == '[') {
                st.add(ch);
            } 
            // 닫는 괄호인 경우 검사
            else if (ch == ')' || ch == ']') {
                // 스택이 비어있거나 짝이 맞지 않으면 실패
                if (st.isEmpty() || !isMatchingPair(st.pop(), ch)) {
                    sb.append("no\n");
                    return;
                }
            }
        }
        // 모든 문자 처리 후 스택이 비어있으면 성공, 아니면 실패
        sb.append(st.isEmpty() ? "yes\n" : "no\n");
    }
    
    // 괄호 짝이 맞는지 확인하는 헬퍼 메소드
    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') || (open == '[' && close == ']');
    }
}