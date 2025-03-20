import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<List<Integer>> array;

    static class Pair {
        int index;
        int step;
        Pair(int index, int step) {
            this.index = index;
            this.step = step;
        }
    }

    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);

        array = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            array.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            in = br.readLine().split(" ");
            int node1 = Integer.parseInt(in[0]);
            int node2 = Integer.parseInt(in[1]);
            array.get(node1).add(node2);
            array.get(node2).add(node1);
        }

        int bacon = Integer.MAX_VALUE;
        int result = 1;
        for (int i = 1; i <= n; i++) {
            boolean[] visit = new boolean[n + 1];
            int value = bfs(array, visit, i);
            if (value < bacon) {
                bacon = value;
                result = i;
            }
        }
        System.out.println(result);
        br.close();
    }

    public static int bfs(List<List<Integer>> array, boolean[] visit, int start) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(start, 0));
        visit[start] = true;
        int bacon = 0;
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            int index = pair.index;
            int step = pair.step;
            for (int friend : array.get(index)) {
                if (!visit[friend]) {
                    visit[friend] = true;
                    q.add(new Pair(friend, step + 1));
                    bacon += (step + 1);
                }
            }
        }
        return bacon;
    }
}
