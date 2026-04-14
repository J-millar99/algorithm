import java.io.*;
import java.util.*;

public class Main {
    static class LengthComparator implements Comparator<String> {
        @Override
        public int compare(String str1, String str2) {
            return str1.length() - str2.length();
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            if (!list.contains(input))
                list.add(input);
        }

        Collections.sort(list);
        Collections.sort(list, new LengthComparator());
        /*
            같은 단어끼리 뭉칠 수 있도록 사전순으로 먼저 정렬한 뒤,
            길이순으로 정렬을 수행하면 같은 단어 내에서 길이가 짧은 것이 앞 순서로 오게 된다.

            길이 먼저 정렬한 뒤 사전순으로 정렬하면, 우선 순위 정렬 기준인 길이가 깨지게 된다.
         */
        for (String str : list)
            System.out.println(str);
        br.close();
    }
}
