import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        Map<String, Boolean> dic = new LinkedHashMap<>();

        String[] in = br.readLine().split(" ");
        int num = Integer.parseInt(in[0]);
        int turn = Integer.parseInt(in[1]);
        for (int i = 1; i <= turn; i++) {
            String id = br.readLine();
            if (dic.containsKey(id))
                dic.remove(id);
            dic.put(id, true);
        }

        Set<String> keySet = dic.keySet();
        Iterator<String> iter = keySet.iterator();
        for (int i = 0; i < num; i++) {
            if (iter.hasNext())
                sb.append(iter.next()).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}