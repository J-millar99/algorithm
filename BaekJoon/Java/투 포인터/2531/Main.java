import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        int n, d, k, c;
        n = Integer.parseInt(in[0]); // 접시 수
        d = Integer.parseInt(in[1]); // 초밥 종류 수
        k = Integer.parseInt(in[2]); // 연속 가능 수
        c = Integer.parseInt(in[3]); // 쿠폰

        int[] cycle = new int[n];
        for (int i = 0; i < n; i++) 
            cycle[i] = Integer.parseInt(br.readLine());
        
        Map<Integer, Integer> field = new HashMap<>();
        for (int i = 0; i < k; i++) // 처음 k개를 기록
            field.put(cycle[i], field.getOrDefault(cycle[i], 0) + 1);
        
        int result = field.size();
        if (!field.containsKey(c)) // 쿠폰 초밥이 존재하지 않으면
            result++;
        
        int st = 0, en = k - 1;
        while (st != n) {
            int sKey = cycle[st];
            field.put(sKey, field.get(sKey) - 1); // st가 증가함에 따라 이전 값 -1;
            st++;
            en = (en + 1) % n; // 회전 조정 값
            int eKey = cycle[en];
            field.put(eKey, field.getOrDefault(eKey, 0) + 1);
            int count = 0;
            for (int key : field.keySet())
                if (field.get(key) != 0) // 개수가 0이 아닌 초밥에 대해서만 개수 세기
                    count++;
            if (!field.containsKey(c) || field.get(c) == 0) // 쿠폰 초밥이 없다면
                count++;
            result = Math.max(result, count);
        }
        System.out.println(result);
        br.close();
    }
}