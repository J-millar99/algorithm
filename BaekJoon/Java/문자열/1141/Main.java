import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        String[] words = new String[num];

        for (int i = 0; i < num; i++)
            words[i] = br.readLine();
        
        // 오름차순 정렬 사용 (원래 코드)
        Arrays.sort(words, Comparator.comparing(String::length));

        boolean[] isPrefix = new boolean[num];
        for (int i = 0; i < num - 1; i++) {
            for (int j = i + 1; j < num; j++) {
                if (words[j].startsWith(words[i])) {
                    isPrefix[i] = true;
                    break;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < num; i++) {
            if (!isPrefix[i]) count++;
        }
        
        System.out.println(count);
        br.close();
    }
}