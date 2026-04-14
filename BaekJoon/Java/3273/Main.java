import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        String[] input = br.readLine().split(" ");
        for (String str : input)
            list.add(Integer.parseInt(str));
        list.sort(Comparator.reverseOrder());

        int count = 0;
        int target = Integer.parseInt(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            if (list.get(i) >= target)
                continue;
            for (int j = n - 1 - count; j > i; j--) {
                int sum = list.get(i) + list.get(j);
                if (sum == target) {
                    count++;
                    break;
                } else if (sum > target)
                    break;
            }
        }
        System.out.println(count);
        br.close();
    }
}
