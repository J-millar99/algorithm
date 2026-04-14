import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        String[] in = br.readLine().split(" ");
        int[] rings = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            rings[i] = Integer.parseInt(in[i -1]);
        }
        for (int i = 2; i <= num; i++) {
            int gcd = getGCD(rings[1], rings[i]);
            sb.append(rings[1]/gcd)
                .append("/")
                .append(rings[i]/gcd)
                .append("\n");
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