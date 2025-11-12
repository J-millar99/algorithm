import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        //[0][]: 최고 자릿수 저장, [1][]: 등장 개수 저장
        int[][] data = new int[2][26];
        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            words[i] = word;
            int len = word.length();
            for (int j = 0; j < len; j++) {
                int idx = word.charAt(j) - 'A';
                data[0][idx] = Math.max(data[0][idx], len - j);
                data[1][idx]++;
            }
        }

        Integer[] indices = new Integer[26]; // 정렬을 위해서 인덱스 배열 생성
        for (int i = 0; i < 26; i++) {
            indices[i] = i; // 알파벳 26개 인덱스(0~26)를 나열 
        }

        // 값을 비교하여 자릿수로 먼저 비교해서 높은 자릿수가 앞으로 오고, 자릿수가 동일하면 등장 개수가 많은 것이 앞으로 옴
        Arrays.sort(indices, (i, j) -> {
            if (data[0][i] != data[0][j]) {
                return Integer.compare(data[0][j], data[0][i]);
            }
            return Integer.compare(data[1][j], data[1][i]);
        });

        int[] mapping = new int[26]; // 수를 문자에 매핑하기위한 배열: 인덱스 = 알파벳
        int weight = 9; // 가중치 9부터 시작
        for (int idx : indices) { // indices는 정렬되어 있으므로
            if (data[1][idx] == 0) // 해당 알파벳이 등장하지 않았으면 매핑을 멈춤
                break;
            mapping[idx] = weight--;
        }

        int sum = 0;
        for (String word : words) {
            int len = word.length();
            int num = 0;
            for (int i = 0; i < len; i++) {
                char ch = word.charAt(i);
                num = num * 10 + mapping[(int)(ch - 'A')];
            }
            sum += num;
        }
        System.out.println(sum);
        br.close();
    }
}