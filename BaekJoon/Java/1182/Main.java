import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, target;
    static int[] node;
    static int[] number;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");
        n = Integer.parseInt(in[0]);
        target = Integer.parseInt(in[1]);

        in = br.readLine().split(" ");
        number = new int[n];
        for (int i = 0; i < n; i++) {
            number[i] = Integer.parseInt(in[i]);
        }
    
        node = new int[n + 1];

        for (int i = 1; i <= n; i++)
            backTracking(1, 1, i);
        System.out.println(count);
        br.close();
    }

    public static void backTracking(int start, int depth, int limit) {
        if (depth == limit + 1) {
            int sum = 0;
            for (int i = 1; i < depth; i++)
                sum += node[i];
            if (sum == target)
                count++;
            return;
        }

        for (int i = start; i <= n; i++) {
            node[depth] = number[i - 1];
            backTracking(i + 1, depth + 1, limit);
        }
    }
}