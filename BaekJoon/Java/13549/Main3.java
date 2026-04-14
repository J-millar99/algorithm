import java.io.*;
import java.util.*;

// Deque
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int LIMIT = 200001;
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        int n, k;

        n = Integer.parseInt(in[0]); // 수빈이의 위치
        k = Integer.parseInt(in[1]); // 동생의 위치
        boolean[] visit = new boolean[LIMIT];
    
        // [1] 시간을 비교하여 최솟값이 우선순위를 가짐
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[1] - b[1]));
        pq.add(new int[]{n, 0}); // 위치와 시간을 같이 저장
        while (true) {
            int[] pair = pq.poll();
            int l = pair[0]; // 현재 위치
            int t = pair[1]; // 현재 시간

            if (l == k) { // 현재 위치가 동생의 위치라면 탐색 종료
                System.out.println(t);
                break;
            }
            if (visit[l]) continue;
            visit[l] = true;

            int teleport = l * 2;
            if ((teleport < LIMIT || l < k) && !visit[teleport])
                pq.add(new int[]{teleport,  t});

            int go = l + 1;
            if ((go < LIMIT || l < k)  && !visit[go])
                pq.add(new int[]{go,  t + 1});

            int back = l - 1;
            if (l != 0  && !visit[back])
                pq.add(new int[]{back,  t + 1});
        }
    }
}
