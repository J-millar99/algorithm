import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        Map<String, String> entrance = new HashMap<>();

        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            String[] in = br.readLine().split(" ");
            if (in[1].equals("enter"))
                entrance.put(in[0], null);
            else if (in[1].equals("leave"))
                entrance.remove(in[0]);
        }

        List<String> arr = new ArrayList<>(entrance.keySet());
        arr.sort(Comparator.reverseOrder());
        for (String string : arr) {
            sb.append(string).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}