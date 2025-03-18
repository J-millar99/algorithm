import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        int tries = Integer.parseInt(in[0]);
        int question = Integer.parseInt(in[1]);

        Map<String, String> idol = new HashMap<>();
        for (int i = 0; i < tries; i++) {
            String group = br.readLine();
            int num = Integer.parseInt(br.readLine());
            for (int j = 0; j < num; j++) {
                String name = br.readLine();
                idol.put(name, group);
            }
        }

        for (int i = 0; i < question; i++) {
            String name = br.readLine();
            // 0 : 멤버의 이름을 사전순 출력, 1 : 속한 팀을 출력
            int type = Integer.parseInt(br.readLine());
            if (type == 1)
                sb.append(idol.get(name)).append("\n");
            else {
                List<String> arr = new ArrayList<>();
                for (String keyName : idol.keySet()) {
                    if (idol.get(keyName).equals(name))
                        arr.add(keyName);
                }
                arr.sort(null);
                for (String string : arr) {
                    sb.append(string).append("\n");
                }
            }
        }
        System.out.print(sb);
        br.close();
    }
}