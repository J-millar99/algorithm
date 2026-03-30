import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[][] field = new char[n][n];
        for (int i = 0; i < n; i++) {
            String in = br.readLine();
            for (int j = 0; j < n; j++) {
                field[i][j] = in.charAt(j);
            }
        }
        br.close();
        divide(field, 0, 0, n);
        System.out.println(sb);
        
    }

    public static void divide(char[][] field, int x, int y, int size) {
        if (checkField(field, x, y, size))
            return;
        else {
            size /= 2;
            divide(field, x, y, size);
            divide(field, x, y + size, size);
            divide(field, x + size, y, size);
            divide(field, x + size, y + size, size);
            sb.append(')');
        }
    }

    public static boolean checkField(char[][] field, int x, int y, int size) {
        char pivot = field[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (field[i][j] != pivot) {
                    sb.append('(');
                    return false;
                }
            }
        }
        sb.append(pivot);
        return true;
    }
}
