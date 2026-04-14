import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        int a = 0, b = 0, c = 0;
        for (int i = 0; i < 3; i++) {
            a = Integer.parseInt(in[0]);
            b = Integer.parseInt(in[1]);
            c = Integer.parseInt(in[2]);
        }

        System.out.println(recursive(a, b, c));
        br.close();
    }

    public static long recursive(int a, int b, int c) {
        if (b == 1)
            return a % c;

        long exp = recursive(a, b / 2, c);
        if (b % 2 == 0) // b가 짝수 이면
            return exp * exp % c;
        else // b가 홀수 이면
            return (((exp * exp) % c) * a ) % c;
    }
}