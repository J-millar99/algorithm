import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int tries = Integer.parseInt(br.readLine());
        for (int i = 0; i < tries; i++) {
            String[] in = br.readLine().split(" ");
            int num = Integer.parseInt(in[0]);
            int[] numbers = new int[num + 1];
            for (int j = 1; j <= num; j++)
                numbers[j] = Integer.parseInt(in[j]);

            long gcdSum = 0;
            for (int i1 = 1; i1 < num; i1++) {
                for (int i2 = i1 + 1; i2 <= num; i2++) {
                    int result = getGCD(numbers[i1], numbers[i2]);
                    gcdSum += result;
                }
            }
            sb.append(gcdSum).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    public static int getGCD(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        if (min == 0)
            return max;
        return getGCD(min, max % min);
    }
}