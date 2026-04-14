import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static final int LIMIT = 100001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        
        int n = Integer.parseInt(in[0]);
        int k = Integer.parseInt(in[1]);
        
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visit = new boolean[LIMIT];

        q.add(new int[]{n, 0});
        visit[n] = true;

        int answer = 0;
        while(!q.isEmpty()) {
            int[] pos = q.poll();
            int loc = pos[0];
            int time = pos[1];

            if (loc == k) {
                answer = time;
                break;
            }
            
            if (loc * 2 < LIMIT && visit[loc * 2] == false) {
                q.add(new int[]{loc * 2, time + 1});
                visit[loc * 2] = true;
            }
            if (loc + 1 < LIMIT && visit[loc + 1] == false) {
                q.add(new int[]{loc + 1, time + 1});
                visit[loc + 1] = true;
            }
            if (loc - 1 >= 0 && visit[loc - 1] == false) {
                q.add(new int[]{loc - 1, time + 1});
                visit[loc - 1] = true;
            }
        }
        System.out.println(answer);
        br.close();
    }
}
