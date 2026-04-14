import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        int[][] tg = new int[num][2]; // tree&growth

        String[] in = br.readLine().split(" ");
        for (int i = 0; i < num; i++) tg[i][0] = Integer.parseInt(in[i]);
        in = br.readLine().split(" ");
        for (int i = 0; i < num; i++) tg[i][1] = Integer.parseInt(in[i]);
    
        Arrays.sort(tg, Comparator.comparing((int[] e) -> e[1]));
        for (int i = 0; i < num; i++) {
            tg[i][0] += i * tg[i][1];
        }
        
        long get = 0;
        for (int i = 0; i < num; i++) {
            get += tg[i][0];
        }
        System.out.print(get);
        br.close();
    }
}