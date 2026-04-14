import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        String[] in = br.readLine().split(" ");

        List<Integer> pos = new ArrayList<>();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            int value = Integer.parseInt(in[i]);
            pos.add(value);
            arr[i] = value;
        }
        pos.sort(null);

        Map<Integer, Integer> dic = new HashMap<>();
        int rank = 0;
        for (int i : pos) // 정렬된 pos에서
            if (!dic.containsKey(i)) // 키가 존재하지 않으면
                dic.put(i, rank++); // 키와 랭크를 추가하고 rank++

        for (int i = 0; i < num; i++) {
            int value = dic.get(arr[i]);
            sb.append(value).append(" ");
        }

        System.out.print(sb);
        br.close();
    }
}