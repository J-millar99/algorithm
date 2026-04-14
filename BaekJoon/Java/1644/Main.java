import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        List<Integer> primeNumbers = new ArrayList<>();        
        final int MAX = 4000000;
        
        boolean[] isNotPrime = new boolean[MAX + 1];
        isNotPrime[0] = isNotPrime[1] = true;
        for (int i = 2; i * i <= MAX; i++) {
            if (isNotPrime[i]) continue;            
            for (int j = i * i; j <= MAX; j += i) {
                isNotPrime[j] = true;
            }
        }
        
        for (int i = 2; i <= MAX; i++) {
            if (!isNotPrime[i]) {
                primeNumbers.add(i);
            }
        }

        int target = Integer.parseInt(br.readLine());
        int count = 0;

        int left;
        int right;

        // left부터 right까지 더하다가
        // 합이 target을 넘으면 left++
        // left가 target을 넘으면 중지
        System.out.println(count);
        br.readLine();
    }
}