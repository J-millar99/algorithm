import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 각각 -1, 0, 1의 개수수
    static int type1 = 0, type2 = 0, type3 = 0;
    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());

        int[][] graph = new int[size][size];
        for (int i = 0; i < size; i++) {
            String[] in = br.readLine().split(" ");
            for (int j = 0; j < in.length; j++) {
                graph[i][j] = Integer.parseInt(in[j]);
            }
        }

        recursive(graph, 0, 0, size);
        System.out.println(type1 + "\n" + type2 + "\n" + type3);
        br.close();
    }

    public static void recursive(int[][] graph, int x, int y, int size) {
        if (size == 0) // base condition
            return ;
        if (checkPaper(graph, x, y, size) == true) {
            if (graph[x][y] == -1)
                ++type1;
            else if (graph[x][y] == 0)
                ++type2;
            else if (graph[x][y] == 1)
                ++type3;
            return ;
        }
        size = size / 3;
        // 숫자 키패드 순
        recursive(graph, x, y, size);                       // 1
        recursive(graph, x, y + size, size);                // 2
        recursive(graph, x, y + size * 2, size);            // 3
        recursive(graph, x + size, y, size);                // 4
        recursive(graph, x + size, y + size, size);         // 5
        recursive(graph, x + size, y + size * 2, size);     // 6
        recursive(graph, x + size * 2, y, size);            // 7
        recursive(graph, x + size * 2, y + size, size);     // 8
        recursive(graph, x + size * 2, y + size * 2, size); // 9
    }

    // x, y 색종이의 시작 좌표, size는 종이의 크기
    public static boolean checkPaper(int[][] graph, int x, int y, int size) {
        int flag = graph[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (graph[i][j] != flag)
                    return false;
            }
        }
        return true;
    }
}