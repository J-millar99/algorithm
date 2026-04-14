import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int size;
    static int number[];
    public static void main(String[] args) throws IOException {
        while (true) {
            String in[] = br.readLine().split(" ");
            size = Integer.parseInt(in[0]);
            if (size == 0)
                break;
            number = new int[size + 1];
            for (int i = 1; i <= size; i++) {
                number[i] = Integer.parseInt(in[i]);
            }
            int[] node = new int[7];
            backTracking(1, 1, node);
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    public static void backTracking(int start, int depth, int[] node) {
        if (depth == 7) {
            for (int i = 1; i <= 6; i++)
                sb.append(node[i]).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = start; i <= size; i++) {
            node[depth] = number[i];
            backTracking(i + 1, depth + 1, node);
        }
    }
}