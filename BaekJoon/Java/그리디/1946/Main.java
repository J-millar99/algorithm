import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int tries = Integer.parseInt(br.readLine());
        for (int i = 0; i < tries; i++) {
            int num = Integer.parseInt(br.readLine());
            int[][] arr = new int[num][2];
            for (int j = 0; j < num; j++) {
                String[] in = br.readLine().split(" ");
                arr[j][0] = Integer.parseInt(in[0]);
                arr[j][1] = Integer.parseInt(in[1]);
            }
            Arrays.sort(arr, Comparator.comparing((int[] e) -> e[0]));
            // 이미 서류 성적은 정렬
            int count = 1;
            int rank = arr[0][1];
            for (int id = 1; id < num; id++) {
                if (arr[id][1] < rank) {
                    count++;
                    rank = arr[id][1];
                }              
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
