import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= num; i++)
            q.add(i);

        while (q.size() != 1) {
            q.poll();
            if (q.size() == 1)
                break;
            int temp = q.poll();
            q.add(temp);
        }

        System.out.println(q.poll());
        br.close();
    }
}
