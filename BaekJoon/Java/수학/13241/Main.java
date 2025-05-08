import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        long a = Long.parseLong(in[0]);
        long b = Long.parseLong(in[1]);

        long r = gcd(a, b);
        System.out.println((a / r) * b);
        br.close();
    }

    public static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}