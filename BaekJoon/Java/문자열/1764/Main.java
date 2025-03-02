import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            map.put(str, 1);
        }

        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            if (map.containsKey(str))
                map.put(str, map.getOrDefault(str, 0) + 1);
        }

        List<String> list = new ArrayList<>();
        for (String str : map.keySet())
            if (map.get(str) == 2)
                list.add(str);

        list.sort(null);
        StringBuilder sb = new StringBuilder();
        for (String str : list)
            sb.append(str).append("\n");
        System.out.print(list.size() + "\n" + sb);
        br.close();
    }    
}
