import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            String s = br.readLine();
            solution(s);
        }
        System.out.print(sb);
        br.close();
    }

    public static void solution(String s) {
        int len = s.length();
        Character[] str = new Character[len];

        for (int i = 0; i < len; i++) {
            str[i] = s.charAt(i);
        }
        
        int idx = swap(str, len);
        if (idx == -1)
            sb.append("BIGGEST");
        // 나머지문자열은 아래 순
        else {
            Arrays.sort(str, idx + 1, len);
            for (char c : str) {
                sb.append(c);
            }
        }
        sb.append("\n");
    }

    public static int swap(Character[] str, int len) {
        for (int i = len - 2; i >= 0; i--) {
            for (int j = len - 1; j > i; j--) {
                if (str[i] < str[j]) {
                    char temp = str[j];
                    str[j] = str[i];
                    str[i] = temp;
                    return i;
                }
            }
        }
        return -1;
    }
}