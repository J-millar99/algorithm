import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int blue = 0, white = 0;
    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());

        char[][] graph = new char[size][size];
        for (int i = 0; i < size; i++) {
            String[] in = br.readLine().split(" ");
            for (int j = 0; j < in.length; j++) {
                graph[i][j] = in[j].charAt(0);
            }
        }

        recursive(graph, 0, 0, size);
        System.out.println(white + "\n" + blue);
        br.close();
    }

    public static void recursive(char[][] graph, int x, int y, int size) {
        if (size == 0) // base condition
            return ;
        if (checkPaper(graph, x, y, size) == true) {
            if (graph[x][y] == '1')
                ++blue;
            else if (graph[x][y] == '0')
                ++white;
            return ;
        }
        size = size / 2;
        recursive(graph, x, y, size);               // 좌 상단
        recursive(graph, x, y + size, size);        // 우 상단
        recursive(graph, x + size, y, size);        // 좌 하단
        recursive(graph, x + size, y + size, size); // 우 하단
    }

    // x, y 색종이의 시작 좌표, size는 종이의 크기
    public static boolean checkPaper(char[][] graph, int x, int y, int size) {
        char flag = graph[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (graph[i][j] != flag)
                    return false;
            }
        }
        return true;
    }
}