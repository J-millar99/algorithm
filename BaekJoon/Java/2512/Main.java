import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        String[] in = br.readLine().split(" ");
        int budget = Integer.parseInt(br.readLine());

        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            arr.add(Integer.parseInt(in[i]));
        }
        arr.sort(null);

        int sum = arr.stream().mapToInt(Integer::intValue).sum();
        if (sum <= budget)
            System.out.println(arr.get(arr.size() - 1));
        else {
            binarySearch(budget, arr);
        }
        br.close();
    }

    // 30 40 70 80 100
    public static void binarySearch(int budget, List<Integer> arr) {
        long result = 0;
        long s = 1;
        long e = budget;
        while(s <= e) {
            long distribute = (s + e) / 2;
            int sum = 0;
            for (Integer integer : arr) {
                if (distribute >= integer)
                    sum += integer;
                else
                    sum += distribute;
            }
            if (sum <= budget) {
                result = distribute;
                s = distribute + 1;
            } else {
                e = distribute - 1;
            }
        }
        System.out.println(result);
    }
}
