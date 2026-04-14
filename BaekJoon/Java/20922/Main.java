import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int limit = Integer.parseInt(in[1]);

        in = br.readLine().split(" ");
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(in[i]);
        }
        int len = 1;
        int st = 0, en = 0;
        Map<Integer, Integer> field = new HashMap<>();
        field.put(num[st], 1);
        while (st < n) { // st가 범위를 넘지 않도록 제한
            en++; // en 포인터 증가
            if (en == n) // en이 끝에 도달하면 탈출
                break;
            field.put(num[en], field.getOrDefault(num[en], 0) + 1); // en포인터가 가리키는 수 증가
            int dup = field.get(num[en]); // 중복 개수 추적
            if (dup > limit) {// 만약 제한 개수를 넘었다면
                while (num[st] != num[en]) { // st를 최초의 num[en]이 등장한 인덱스로 이동
                    int value = field.get(num[st]);
                    field.put(num[st], value - 1); // 이전 등장값을 거쳐오면서 -1
                    st++;
                }
                st++; // 제한 개수를 -1 줄이기 위해 다음 인덱스로 이동
                field.put(num[en], limit); // 중복 개수를 한 개 줄여 저장
            }
            len = Math.max(en - st + 1, len);
        }
        System.out.println(len);
        br.close();
    }
}