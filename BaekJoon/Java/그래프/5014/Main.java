import java.io.*;
import java.util.*;

public class Main {
    static int floor, current, end, up, down;
    static class Pair {
        int cur, step;
        Pair(int cur, int step) {
            this.cur = cur;
            this.step = step;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        /*
            F: 총 층
            S: 현재 층
            G: 도착 층
            U: 상승 수
            D: 하강 수
        */
        floor = Integer.parseInt(in[0]);
        current = Integer.parseInt(in[1]);
        end = Integer.parseInt(in[2]);
        up = Integer.parseInt(in[3]);
        down = Integer.parseInt(in[4]);
        System.out.println(solution());
        br.close();
    }

    public static String solution() {
        Queue<Pair> q = new ArrayDeque<>();
        boolean[] visit = new boolean[floor + 1];

        q.add(new Pair(current, 0));
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            if (pair.cur > floor || pair.cur <= 0 || visit[pair.cur] == true)
                continue;
            if (pair.cur == end)
                return String.valueOf(pair.step);
            visit[pair.cur] = true;
            q.add(new Pair(pair.cur + up, pair.step + 1));
            q.add(new Pair(pair.cur - down, pair.step + 1));
        }
        return "use the stairs"; // 도착 불가능한 경우
    }
}