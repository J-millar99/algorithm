import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());
        String[] in = br.readLine().split(" ");
        List<Integer> arr = new ArrayList<>();
        Map<Integer, Integer> dic = new HashMap<>();
        for (int i = 0; i < size; i++) {
            int key = Integer.parseInt(in[i]);
            dic.put(key, dic.getOrDefault(key, 0) + 1);
            arr.add(key);
        }
        arr.sort(null);

        int num = Integer.parseInt(br.readLine());
        in = br.readLine().split(" ");
        int[] card = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            card[i] = Integer.parseInt(in[i - 1]);
        }

        for (int i = 1; i <= num; i++) {
            if (binarySearch(card[i], arr) == true)
                sb.append(dic.get(card[i]));
            else
                sb.append("0");
            sb.append(" ");
        }

        System.out.println(sb);
        br.close();
    }

    public static boolean binarySearch(int find, List<Integer> arr) {
        int s = 0;
        int e = arr.size() - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            int target = arr.get(mid);
            if (target == find)
                return true;
            else if (target < find) 
                s = mid + 1;
            else
                e = mid - 1;
        }
        return false;
    }
}