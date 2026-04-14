import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Long, Long> field = new HashMap<>();

        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            Long key = Long.parseLong(br.readLine());
            field.put(key, field.getOrDefault(key, (long)0) + 1);
        }

        ArrayList<Long> arr = new ArrayList<>();
        Long value = Collections.max(field.values());
        for (Long key : field.keySet())
            if (field.get(key).equals(value)) // 자바의 객체끼리의 비교는 반드시 equals
                arr.add(key);
        arr.sort(null);
        System.out.println(arr.get(0));
        br.close();
    }
}