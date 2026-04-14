import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int tries = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tries; i++) {   
            String[] in = br.readLine().split(" ");
            int a, b;
            a = Integer.parseInt(in[0]);
            b = Integer.parseInt(in[1]);
            int gcd = getGCD(a, b);
            long lcm = (long) a / gcd * b;
            sb.append(lcm).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    public static int getGCD(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        if (min == 0)
            return max;
        return getGCD(min, max % min);
    }
}