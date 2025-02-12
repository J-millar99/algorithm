import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
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

            Map<Integer, Integer> weight = new HashMap<>();
            for (int index = 0; index < strs.length; index++)
                weight.put(index, Integer.parseInt(strs[index]));
            printQueue(n, m, weight);
        }
        br.close();
    }

    public static void printQueue(int size, int find, Map<Integer, Integer> weight) {
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> priority = new ArrayList<>();
    
        for (int i = 0; i < size; i++) {
            Integer value = weight.get(i);
            priority.add(value);
            queue.add(value);
            }
        Collections.sort(priority, Collections.reverseOrder());
    
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
