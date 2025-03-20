import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<List<Integer>> array;
    static int distance, number, count;
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

        boolean[] visit = new boolean[n + 1];
        bfs(array, visit);
        System.out.println(number + " " + distance + " " + (count + 1));
        br.close();
    }

    public static void bfs(List<List<Integer>> array, boolean[] visit) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(1, 0));
        visit[1] = true;
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            int index = pair.index;
            int step = pair.step;
            for (int barn : array.get(index)) {
                if (!visit[barn]) {
                    visit[barn] = true;
                    q.add(new Pair(barn, step + 1));
                    if (distance < step + 1) { // 최댓값이 갱신되면
                        distance = step + 1;
                        number = barn;
                        count = 0;
                    } else if (distance == step + 1) { // 최댓값이 지속되면 헛간 개수 기록
                        count++;
                        if (number > barn)
                            number = barn;
                    }
                }
            }
        }
    }
}
