import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int primeNumber(int num) {
        if (num == 1)
            return 0;
        int root = (int)Math.sqrt(num);
        for (int i = 2; i <= root; i++) {
            if (num % i == 0)
                return 0;
        }
        return 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = 1;
        while (true) {
            int count = 0;
            num = Integer.parseInt(br.readLine());
            if (num == 0)
                break;
            for (int i = num + 1; i <= 2 * num; i++)
                count += primeNumber(i);
            sb.append(count).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
        br.close();
    }
}