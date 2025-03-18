import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int tries = Integer.parseInt(br.readLine());

        for (int i = 0; i < tries; i++) {
            Map<String, Integer> cloth = new HashMap<>();
            int num = Integer.parseInt(br.readLine());
            for (int j = 0; j < num; j++) {
                String in[] = br.readLine().split(" ");
                cloth.put(in[1], cloth.getOrDefault(in[1], 0) + 1);
            }
            if (cloth.size() == 0) {
                sb.append(0);
            } else if (cloth.size() == 1) {
                sb.append(num);
            } else {

            }
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}