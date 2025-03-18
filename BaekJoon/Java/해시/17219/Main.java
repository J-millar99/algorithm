import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        Map<String, String> dic = new HashMap<>();

        String[] in = br.readLine().split(" ");
        int num = Integer.parseInt(in[0]);
        int question = Integer.parseInt(in[1]);
        for (int i = 1; i <= num; i++) {
            in = br.readLine().split(" ");
            dic.put(in[0], in[1]);
        }

        for (int i = 0; i < question; i++) {
            String input = br.readLine();
            sb.append(dic.get(input)).append("\n");
        }
        
        System.out.print(sb);
        br.close();
    }
}