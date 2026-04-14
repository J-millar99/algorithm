import java.io.*;
import java.util.*;

/*
* keySet() : 키를 set 형태로 반환.
* values() : 값을 Collection<V> 형태로 반환. 참조 변수에 따라 V가 결정
* entrySet() : Map.Entry<K, V> 형태로 반환.
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");

        int n = Integer.parseInt(in[0]);
        int c = Integer.parseInt(in[1]);

        // 맵에 키(수)와 빈도를 저장
        Map<Integer, Integer> field = new LinkedHashMap<>(); // 입력 순서 보장 맵
        in = br.readLine().split(" ");
        for (String str : in) {
            if (!str.isEmpty()) {
                int key = Integer.parseInt(str);
                field.put(key, field.getOrDefault(key, 0) + 1);
            }
        }

        // 정렬된 맵을 반환
        List<Map.Entry<Integer, Integer>> sorted_list = sortByFrequency(field);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Integer> e : sorted_list) {
            int rept = e.getValue();
            for (int i = 0; i < rept; i++) {
                sb.append(e.getKey()).append(" ");
            }
        }
        System.out.println(sb);
        br.close();
    }

    // 맵 정렬
    public static List<Map.Entry<Integer, Integer>> sortByFrequency(Map<Integer, Integer> map) {
        // Entry 리스트 생성
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        // 빈도(값) 기준 내림차순 정렬, 빈도 같으면 기존 순서 유지
        entryList.sort((e1, e2) -> {
            int freqCompare = Integer.compare(e2.getValue(), e1.getValue()); // 내림차순 정렬
            return freqCompare;
        });
        return entryList;
    }
}