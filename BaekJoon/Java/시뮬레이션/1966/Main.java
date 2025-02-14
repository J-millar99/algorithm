import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int tries = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < tries; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            String[] strs = br.readLine().split(" ");
            Queue<Integer> queue = new ArrayDeque<>();
            List<Integer> priority = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                Integer value = Integer.parseInt(strs[j]);
                priority.add(value);
                queue.add(value);
            }

            Collections.sort(priority, Collections.reverseOrder());
            printQueue(queue, priority, m);
        }
        br.close();
    }

    public static void printQueue(Queue<Integer> queue, List<Integer> priority, int find) {
        int count = 0;
        while (!queue.isEmpty()) {
            Integer request = queue.poll();
            Integer target = priority.get(count);
            find--;

            if (request.equals(target)) {
                count++;
                if (find == -1)
                    break;
            } else {
                queue.add(request);
                if (find < 0)
                    find = queue.size() - 1;
            }
        }
        System.out.println(count);
    }
}
