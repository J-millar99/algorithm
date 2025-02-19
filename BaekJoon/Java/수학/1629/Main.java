import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int base = Integer.parseInt(input[0]);
        int exponent = Integer.parseInt(input[1]);
        int divisor = Integer.parseInt(input[2]);

        long ret = multiply(base, exponent, divisor);
        System.out.println(ret);
        br.close();
    }
    
    public static long multiply(int base, int exp, int div) {
        if (div == 1)
            return 0;
        if (exp == 1)
            return base % div;
        
        long kn = multiply(base, exp / 2, div);
        if (exp % 2 == 0)
            return (kn * kn) % div;
        else
            return (((kn * kn) % div) * base) % div;
    }
}