import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        int e, s, m;
        e = Integer.parseInt(in[0]);
        s = Integer.parseInt(in[1]);
        m = Integer.parseInt(in[2]);

        int num = 1;
        while (num <= 15 * 28 * 19) {
            if ((num - 1) % 15 + 1 == e
                && (num - 1) % 28 + 1== s
                && (num - 1) % 19 + 1 == m)
                break;
            num++;
        }

        System.out.println(num);
        br.close();
    }
}