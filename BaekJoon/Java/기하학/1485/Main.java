import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int tries = Integer.parseInt(br.readLine());
        int[][] cord = new int[4][2];
        for (int i = 0; i < tries; i++) {
            for (int j = 0; j < 4; j++) {
                String in[] = br.readLine().split(" ");
                cord[j][0] = Integer.parseInt(in[0]);
                cord[j][1] = Integer.parseInt(in[1]);
            }
            if (solution(cord))
                sb.append(1);
            else
                sb.append(0);
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    public static boolean solution(int[][] cord) {
        Set<Double> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 4; j++) {
                double value = Math.sqrt(Math.pow(cord[i][0] - cord[j][0], 2) + Math.pow(cord[i][1] - cord[j][1], 2));
                set.add(value);
            }
        }

        if (set.size() == 2)
            return true;
        return false;
    }
}