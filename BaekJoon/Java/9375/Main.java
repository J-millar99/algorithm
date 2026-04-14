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

            int[] arr = new int[cloth.size()];
            int idx = 0;
            for (String string : cloth.keySet()) {
                arr[idx] = cloth.get(string) + 1;
                idx++;
            }
            int result = 1;
            for (int j = 0; j < arr.length; j++) {
                result *= arr[j];
            }
            sb.append(result - 1).append("\n"); // 아무것도 안입는 경우  -1
        }
        
        System.out.print(sb);
        br.close();
    }
}