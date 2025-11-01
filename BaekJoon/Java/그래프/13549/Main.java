import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int LIMIT = 200001;
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        int n, k;
        int minTime = Integer.MAX_VALUE;
        int found = Integer.MAX_VALUE;

        n = Integer.parseInt(in[0]); // 수빈이의 위치
        k = Integer.parseInt(in[1]); // 동생의 위치

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{n, 0}); // 위치와 시간을 같이 저장
        while (true) {
            int[] pair = q.poll();
            int l = pair[0]; // 현재 위치
            int t = pair[1]; // 현재 시간
            if (found < t)
                break;
            if (l == k) { // 현재 위치가 동생의 위치라면 같은 시간대의 큐를 탐색
                minTime = Math.min(t, minTime);
                found = t;
            }
            int teleport = l * 2;
            int go = l + 1;
            int back = l - 1;
            if (teleport < LIMIT)
                q.add(new int[]{teleport,  t});
            if (go < LIMIT)
                q.add(new int[]{go,  t + 1});
            if (l != 0)
                q.add(new int[]{back,  t + 1});
        }

        System.out.println(minTime);
    }
}
