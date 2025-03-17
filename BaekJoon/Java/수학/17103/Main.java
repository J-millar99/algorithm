import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int limit = 1000001;
        boolean[] goldbah = new boolean[limit];
        goldbah[0] = goldbah[1] = true;
        for (int i = 2; i * i < limit ; i++) {
            for (int j = i * i; j < limit; j += i) {
                goldbah[j] = true;
            }
        }
        List<Integer> arr = new ArrayList<>();
        for (int i = 2; i < goldbah.length; i++) {
            if (goldbah[i] == false)
                arr.add(i);
        }

        int tries = Integer.parseInt(br.readLine());
        for (int i = 0; i < tries; i++) {
            int num = Integer.parseInt(br.readLine());
            solution(num, arr);
        }
        System.out.print(sb);
        br.close();
    }

    public static void solution(int num, List<Integer> arr) {
        int count = 0;
        int left = 0;
        int right = arr.size() - 1;

        while(left <= right) {
            int sum = arr.get(left) + arr.get(right);
            if (sum == num) {
                count++;
                left++;
                right--;
            } else if (sum < num) {
                left++;
            } else {
                right--;
            }
        }
        sb.append(count).append("\n");
    }
}