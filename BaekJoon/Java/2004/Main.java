import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        
        // nCm = n! / (m! * (n-m)!)
        // 2의 개수 = n!의 2의 개수 - m!의 2의 개수 - (n-m)!의 2의 개수
        // 5의 개수도 마찬가지
        
        // 2의 개수와 5의 개수 계산
        int count2 = countFactor(n, 2) - countFactor(m, 2) - countFactor(n-m, 2);
        int count5 = countFactor(n, 5) - countFactor(m, 5) - countFactor(n-m, 5);
        
        // 0의 개수는 2와 5 중 더 작은 값
        int result = Math.min(count2, count5);
        
        System.out.println(result);
        br.close();
    }
    
    // n!에서 factor의 개수를 세는 함수
    // 25 12
    public static int countFactor(int n, int factor) {
        int count = 0;
        long div = factor;
        while (div <= n) {  // 25는 25 / 2 -> 13이므로 2로 나누어지는 수를 13개 가짐
                            // 25는 25 / 4 -> 6이므로 4로 나누어지는 수를 4개 가짐
            count += n / div;
            div *= factor;
        }
        
        return count;
    }
}