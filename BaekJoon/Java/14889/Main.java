import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> arr = new ArrayList<>();
    static int n;
    static int size;
    static int[] node1;
    static int[][] field;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        field = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            String[] in = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                field[i][j] = Integer.parseInt(in[j - 1]);
            }
        }

        size = n / 2;
        node1 = new int[size + 1]; // n은 항상 짝수라는 조건
        backTracking(1, 1);
        arr.sort(null);
        System.out.println(arr.get(0));
        br.close();
    }

    public static void backTracking(int start, int depth) {
        if (depth == size + 1) {
            int[] node2 = getNode2(node1);
            int t1 = 0;
            int t2 = 0;
            for (int i = 1; i <= size; i++) {
                int row = node1[i];
                for (int j = i + 1; j <= size; j++) {
                    int col = node1[j];
                    t1 += (field[row][col] + field[col][row]);
                }
            }

            for (int i = 1; i <= size; i++) {
                int row = node2[i];
                for (int j = i + 1; j <= size; j++) {
                    int col = node2[j];
                    t2 += (field[row][col] + field[col][row]);
                }
            }
            arr.add(Math.abs(t1 - t2));
            return;
        }

        for (int i = start; i < n; i++) {
            node1[depth] = i;
            backTracking(i + 1, depth + 1);
        }
    }

    public static int[] getNode2(int[] node1) {
        boolean[] flag = new boolean[n + 1];
        int[] node2 = new int[size + 1];
        for (int i = 1; i <= size; i++)
            flag[node1[i]] = true;

        int idx = 1;
        for (int i = 1; i <= n; i++)
            if (flag[i] == false)
                node2[idx++] = i;
        return node2;
    }
}