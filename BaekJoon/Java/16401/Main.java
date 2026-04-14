import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        int num = Integer.parseInt(in[0]);
        int k = Integer.parseInt(in[1]);

        List<Integer> arr = new ArrayList<>();
        in = br.readLine().split(" ");
        for (int i = 0; i < k; i++) {
            arr.add(Integer.parseInt(in[i]));
        }
        arr.sort(null);
        System.out.println(binarySearch(num, arr));
        br.close();
    }

    public static long binarySearch(int num, List<Integer> arr) {
        long s = 1;
        long e = arr.get(arr.size() - 1);
        long result = 0;
        while(s <= e) {
            long mid = (s + e) / 2;
            int sum = 0;
            for (Integer integer : arr) {
                sum += integer / mid;
            }
            if (sum >= num) {
                result = mid;
                s = mid + 1;
            } else
                e = mid - 1;
        }
        return result;
    }
}