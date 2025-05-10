import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int tries = Integer.parseInt(br.readLine());

        for (int i = 0; i < tries; i++) {
            String[] in = br.readLine().split(" ");
            int n = Integer.parseInt(in[0]);
            Integer[] score = new Integer[n];
            for (int j = 1; j <= n; j++) {
                score[j - 1] = Integer.parseInt(in[j]);
            }

            sb.append("Class " + (i + 1)).append("\n");
            solution(score, n);
        }
        System.out.print(sb);
        br.close();
    }

    public static void solution(Integer[] score, int size) {
        Arrays.sort(score, Comparator.reverseOrder());
        sb.append("Max " + score[0] + ", Min " + score[size - 1] + ", Largest gap ");
        int maxGap = 0;
        int prev = score[0];
        for (int i = 1; i < size; i++) {
            maxGap = Math.max(maxGap, Math.abs(prev - score[i]));
            prev = score[i];
        }
        sb.append(maxGap).append("\n");
    }
}