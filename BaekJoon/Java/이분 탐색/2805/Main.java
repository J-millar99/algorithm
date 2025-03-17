import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n, m;
        String[] in = br.readLine().split(" ");
        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);

        in = br.readLine().split(" ");
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < in.length; i++) {
            arr.add(Integer.parseInt(in[i]));
        }
        arr.sort(null);
        
        System.out.println(binarySearch(m, arr));
        br.close();
    }

    public static int binarySearch(int target, List<Integer> arr) {
        long s = 1;
        long e = arr.get(arr.size() - 1);
        long mid = 0;
        int ret = 0;
        while (s <= e) {
            mid = (s + e) / 2;
            long sum = lengthSum(mid, arr);
            if (sum >= target) {
                ret = (int)mid;
                s = mid + 1;
            }
            else
                e = mid - 1;
        }
        return ret;
    }

    public static long lengthSum(long height, List<Integer> arr) {
        long result = 0;
        for (long e : arr) {
            if (e - height > 0)
                result += e - height;
        }
        return result;
    }
}