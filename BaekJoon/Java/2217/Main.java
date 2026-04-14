import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> arr = new ArrayList<>();
        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k ; i++) {
            int weight = Integer.parseInt(br.readLine());
            arr.add(weight);
        }
        arr.sort(null);
        int size = arr.size();
        int max_weight = 0;
        for (int i = size - 1; i >= 0; i--) {
            max_weight = Math.max(max_weight, arr.get(i) * (size - i));
        }
        System.out.println(max_weight);
        br.close();
    }
}