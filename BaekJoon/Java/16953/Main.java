import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int MAX = 1000000000;
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        boolean[] visit = new boolean[MAX + 1];

        int start = Integer.parseInt(in[0]);
        int target = Integer.parseInt(in[1]);
        int result = -2;

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{start, 0});
        visit[start] = true;

        while (!q.isEmpty()) {
            int[] e = q.poll();
            if (e[0] == target) {
                result = e[1];
                break;
            }
            int step = e[1];

            if (e[0] <= MAX / 2) {
                int idx = e[0] * 2;
                if (visit[idx] == false) {
                    q.add(new int[]{idx, step + 1});
                    visit[idx] = true;
                }
            }

            if (e[0] <= MAX / 10 - 1) {
                int idx = e[0] * 10 + 1;
                if (visit[idx] == false) {
                    q.add(new int[]{idx, step + 1});
                    visit[idx] = true;
                }
            }

        }
        System.out.print(result + 1);
        br.close();
    }
}