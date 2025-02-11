import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    static int sugar, result;
    public static void func(int n) {
        if (n % 5 == 0) {
            result += n / 5;
            return;
        }
        else {
            result += 1;
            n -= 3;
        }
        if (n >= 3)
            func(n);
        else if (n != 0)
            result = -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sugar = Integer.parseInt(br.readLine());

        func(sugar);
        System.out.println(result);
        br.close();
    }
}
