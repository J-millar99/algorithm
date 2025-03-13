import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int tries = Integer.parseInt(br.readLine());
        for (int i = 0; i < tries; i++) {
            int day = Integer.parseInt(br.readLine());

            String[] in = br.readLine().split(" ");

            int[] stock = new int[day + 1];
            for (int j = 1; j <= day; j++) {
                stock[j] = Integer.parseInt(in[j - 1]);
            }

            solution(stock, day);
        }
        System.out.print(sb);
        br.close();
    }

    public static void solution(int[] stock, int day) {
        int maxValue = 0;
        long profit = 0;
        for (int i = day; i > 0; i--) {
            if (stock[i] > maxValue) {
                maxValue = stock[i];
            } else {
                profit += maxValue - stock[i];
            }
        }
        sb.append(profit).append("\n");
    }
}

