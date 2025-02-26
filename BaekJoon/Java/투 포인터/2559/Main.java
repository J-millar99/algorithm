import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int size = Integer.parseInt(input[1]);
        
        List<Integer> list = new ArrayList<>();
        input = br.readLine().split(" ");
        for (String str : input)
            list.add(Integer.parseInt(str));

        int sum = 0;
        for (int i = 0; i < size; i++)
            sum += list.get(i);
        
        int max = sum;
        for (int i = 0; i < n - size; i++) {
            max = Math.max(max, sum - list.get(i) + list.get(size + i));
            sum = sum - list.get(i) + list.get(size + i);
        }
        System.out.println(max);
        br.close();
    }
}
