import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        double[][] disArr = new double[num][2];
        for (int i = 1; i <= num; i++) {
            String[] in = br.readLine().split(" ");

            int x, y, v;
            x = Integer.parseInt(in[0]);
            y = Integer.parseInt(in[1]);
            v = Integer.parseInt(in[2]);

            double dis = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) / (double)v;
            disArr[i - 1][0] = i; // i - 1인덱스에 i번째를 기록
            disArr[i - 1][1] = dis;
        }

        Arrays.sort(disArr, Comparator.comparing((double[] d) -> d[1]).thenComparing(d -> d[0]));
        for (double[] es : disArr) {
            sb.append((int)es[0]).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}