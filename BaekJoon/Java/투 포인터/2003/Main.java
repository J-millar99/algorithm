import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int target = Integer.parseInt(input[1]);
        
        List<Integer> list = new ArrayList<>();
        input = br.readLine().split(" ");
        for (String str : input)
            list.add(Integer.parseInt(str));

        int s = 0;
        int e = 0;
        int sum = list.get(0);
        int cnt = 0;
        while (true) {
            if (sum < target) {
                e++;
                if (e == n)
                    break;
                sum += list.get(e);
            }
            else if (sum > target) {
                ++s;
                if (s == n)
                    break;
                e = s;
                sum = list.get(s);
            }
            else {
                cnt++;
                e = ++s;
                if (s == n)
                    break;
                sum = list.get(s);
            }
        }
        System.out.println(cnt);
        br.close();
    }
}
