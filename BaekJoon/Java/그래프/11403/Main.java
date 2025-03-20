import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static char[][] graph;
    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());
        List<List<Integer>> list = new ArrayList<>();
        graph = new char[size][size];
    
        for (int i = 0; i < size; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < size; i++) {
            String[] in = br.readLine().split(" ");
            for (int j = 0; j < in.length; j++) {
                int val = Integer.parseInt(in[j]);
                if (val == 1) {
                    list.get(i).add(j);
                }
            }
        }
        for (int i = 0; i < size; i++) {
            boolean[] visit = new boolean[size];
            _search(list, visit, i);
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (graph[i][j] == '1')
                    sb.append(graph[i][j]);
                else
                    sb.append("0");
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    public static void _search(List<List<Integer>> list, boolean[] visit, int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        while (!q.isEmpty()) {
            int index = q.poll();
            for (Integer integer : list.get(index)) {
                if (!visit[integer]) {
                    q.add(integer);
                    visit[integer] = true;
                    graph[start][integer] = '1';
                }
            }
        }
    }
}