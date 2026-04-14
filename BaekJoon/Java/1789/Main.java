import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long num = Long.parseLong(br.readLine());
        long sum = 0;
        long i = 1;
        while (true) {
            sum += i;
            if (sum >= num)
                break;
            ++i;
        }
        if (sum == num)
            System.out.println(i);
        else
            System.out.println(i - 1);
        br.close();
    }
}
