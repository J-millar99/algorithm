import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        int num1 = Integer.parseInt(in[0]);
        int den1 = Integer.parseInt(in[1]);

        in = br.readLine().split(" ");
        int num2 = Integer.parseInt(in[0]);
        int den2 = Integer.parseInt(in[1]);

        int gcd = getGCD(den1, den2);
        
        int den = den1 * den2 / gcd;
        int num = (num1 * (den / den1)) + (num2 * (den / den2));

        gcd = getGCD(den, num);
        den /= gcd;
        num /= gcd;
        System.out.println(num + " " + den);
        br.close();
    }

    public static int getGCD(int a, int b) {
        if (b == 0)
            return a;
        return getGCD(b, a % b);
    }
}