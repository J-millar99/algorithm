import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] zero = new int[41];
    static int[] one = new int[41];
    static int target;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tries = Integer.parseInt(br.readLine());

        zero[0] = 1; one[0] = 0;
        zero[1] = 0; one[1] = 1;
        fibonacciDp();
        for (int i = 0; i < tries; i++) {
            int find = Integer.parseInt(br.readLine());
            System.out.println(zero[find] + " " + one[find]);
        }
        br.close();
    }
    public static void fibonacciDp() {
        for (int i = 2; i < 41; i++) {
            zero[i] = zero[i - 1] + zero[i - 2];
            one[i] = one[i - 1] + one[i - 2];
        }
    }
}
