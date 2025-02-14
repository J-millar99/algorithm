import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void primeNumber(int num) {
        if (num == 1)
            return;
        int root = (int)Math.sqrt(num);
        for (int i = 2; i <= root; i++) {
            if (num % i == 0)
                return;
        }
        System.out.println(num);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        for (int i = start; i <= end; i++)
            primeNumber(i);
        br.close();
    }
}
