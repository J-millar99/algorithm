import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        Map<String, Integer> dicString = new HashMap<>();
        Map<String, String> dicInteger = new HashMap<>();

        String[] in = br.readLine().split(" ");
        int num = Integer.parseInt(in[0]);
        int question = Integer.parseInt(in[1]);
        for (int i = 1; i <= num; i++) {
            String name = br.readLine();
            dicString.put(name, i);
            dicInteger.put(String.valueOf(i), name);
        }
        for (int i = 0; i < question; i++) {
            String input = br.readLine();
            char ch = input.charAt(0);
            if ('0' <= ch && ch <= '9') // 숫자면
                sb.append(dicInteger.get(input));
            else // 알파벳이면
                sb.append(dicString.get(input));
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}