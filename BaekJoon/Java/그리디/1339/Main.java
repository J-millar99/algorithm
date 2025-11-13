import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        // 자릿수 (1~10)에서 해당 알파벳이 몇 개가 나왔는지 판단
        int[][] data = new int[11][26]; // 1~10 인덱스 사용
        String[] words = new String[n];

        // 데이터 삽입
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            words[i] = word;
            int len = word.length();
            for (int j = 0; j < len; j++) {
                int idx = word.charAt(j) - 'A';
                data[len - j][idx]++; // 어떤 자릿수에 어떤 알파벳이 몇 개 나왔는지 기록
            }
        }

        // 순회하면서 특정 자릿수에 10개가 등장한 알파벳은 자릿수 +1
        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 26; j++) {
                if (data[i][j] >= 10) {
                    data[i][j] -= 10;
                    data[i+1][j]++;
                }
            }
        }

        // 알파벳 정렬을 위한 리스트 생성
        List<Character> alphabets = new ArrayList<>();
        Set<Character> usedChars = new HashSet<>();
        
        for (String word : words) {
            for (char c : word.toCharArray()) {
                usedChars.add(c);
            }
        }
        alphabets.addAll(usedChars);

        // 커스텀 정렬
        Collections.sort(alphabets, new Comparator<Character>() {
            @Override
            public int compare(Character c1, Character c2) {
                int idx1 = c1 - 'A';
                int idx2 = c2 - 'A';
                
                // 1. 가장 높은 자릿수부터 비교
                for (int digit = 10; digit >= 1; digit--) {
                    // 2. 해당 자릿수의 알파벳 개수로 비교
                    if (data[digit][idx1] != data[digit][idx2]) {
                        return data[digit][idx2] - data[digit][idx1]; // 내림차순 (개수가 많은 것이 앞)
                    }
                    // 3. 동일하면 다음 자릿수(1 작은 자릿수)로 이동
                }
                
                return 0; // 모든 자릿수가 동일
            }
        });

        // 정렬된 알파벳 순서로 매핑
        int[] alphabet = new int[26];
        int weight = 9;
        for (char c : alphabets)
            alphabet[(int)(c - 'A')] = weight--;

        int sum = 0;
        for (String word : words) {
            int value = 0;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                value = value * 10 + alphabet[(int)(ch - 'A')];
            }
            sum += value;
        }
        System.out.println(sum);
        br.close();
    }
}