import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visit = new boolean[100001];
    static Queue<Pair> q = new ArrayDeque<>();

    static class Pair {
        int location, depth;
        Pair(int location, int depth) {
            this.location = location;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]); int k = Integer.parseInt(strs[1]);
        System.out.println(hideAndSeek(n, k));
        br.close();
    }

    public static int hideAndSeek(int n, int k) {
        Pair pair = new Pair(n, 0);
        q.add(pair); // 처음 위치

        while (!q.isEmpty()) {
            pair = q.poll();
            if (pair.location < 0 || pair.location > 100000 || visit[pair.location] == true)
                continue;
            visit[pair.location] = true;
            if (pair.location == k)
                return pair.depth;
            q.add(new Pair(pair.location + 1, pair.depth + 1));
            q.add(new Pair(pair.location - 1, pair.depth + 1));
            q.add(new Pair(pair.location * 2, pair.depth + 1));
        }
        return 0;
    }
}