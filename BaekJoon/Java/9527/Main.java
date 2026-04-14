import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long count = 0;
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");

        long s = Long.parseLong(in[0]);
        long e = Long.parseLong(in[1]);

        solution(s, e);
        br.close();
    }

    public static void solution(long s, long e) {
        long count = countOnesUpTo(e) - countOnesUpTo(s - 1);
        System.out.println(count);
    }

    public static long countOnesUpTo(long x) {
        long count = 0;
        for (int i = 0; i < 64; i++) {
            long groupSize = 1L << (i + 1);
            long fullGroups = (x + 1) / groupSize;
            long remainder = (x + 1) % groupSize;
            count += fullGroups * (groupSize / 2);
            count += Math.max(0, remainder - (groupSize / 2));
        }
        return count;
    }

}