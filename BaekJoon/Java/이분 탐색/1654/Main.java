import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int k = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);

        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < k; i++)
            arr.add(Integer.parseInt(br.readLine()));
        Collections.sort(arr);

        solution(arr, k, n);
        br.close();
    }

    public static void solution(List<Integer> arr, int k, int n) {
        long s = 1;
        long e = arr.get(k - 1);
        long ret = 0;
        while (s <= e) {
            long mid = (s + e) / 2;
            int count = 0;
            for (long lan : arr)
                count += lan / mid;
            if (count >= n) { // 랜선 개수가 충족된다면 길이를 더 길게
                ret = mid;
                s = mid + 1;
            } else { // 랜선 개수가 적게 나왔다면 길이를 더 짧게
                e = mid - 1;
            }
        }
        System.out.println(ret);
    }
}