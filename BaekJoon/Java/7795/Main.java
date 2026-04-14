import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int tries = Integer.parseInt(br.readLine());
        for (int i = 0; i < tries; i++) {
            String[] in = br.readLine().split(" ");
            int left_size = Integer.parseInt(in[0]);
            int right_size = Integer.parseInt(in[1]);

            // 좌측 배열 입력
            List<Integer> left_array = new ArrayList<>();
            in = br.readLine().split(" ");
            for (int idx = 0; idx < left_size; idx++)
                left_array.add(Integer.parseInt(in[idx]));

            // 우측 배열 입력
            List<Integer> right_array = new ArrayList<>();
            in = br.readLine().split(" ");
            for (int idx = 0; idx < right_size; idx++)
                right_array.add(Integer.parseInt(in[idx]));

            right_array.sort(null); // 우측 배열을 정렬한 뒤,
            // 우측 배열의 처음과 끝값, 최솟값과 최댓값을 이용하여 큰 쌍의 개수를 O(1)로 처리.
            // 나머지 수들은 이분탐색으로 처리

            int sum = 0;
            int _min = right_array.get(0);
            int _max = right_array.get(right_array.size() - 1);
            for (Integer integer : left_array) {
                if (integer <= _min) // 큰 쌍이 없는 경우
                    continue;
                else if (integer > _max) // 모든 쌍이 가능한 경우
                    sum += right_array.size();
                else // 이분 탐색으로 개수 세기
                    sum += binarySearch(right_array, integer);
            }
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    public static int binarySearch(List<Integer> array, int target) {
        int s = 0;
        int e = array.size() - 1;
        int idx = 0;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (array.get(mid) >= target) { // 왼쪽 이동
                e = mid - 1;
                idx = mid;
            }
            else if (array.get(mid) < target) // 오른쪽 이동
                s = mid + 1;
        }
        return idx;
    }
}