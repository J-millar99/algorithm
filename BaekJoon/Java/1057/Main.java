import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        int num = Integer.parseInt(in[0]);
        int n1 = Integer.parseInt(in[1]);;
        int n2 = Integer.parseInt(in[2]);
        solution(num, n1, n2);
        br.close();
    }

    public static void solution(int num, int n1, int n2) {
        int round = 1;
        while (num >= 2) {
            if (num % 2 == 1)
                num++;
            if (n1 % 2 == 1)
                n1++;
            n1 /= 2;
            if (n2 % 2 == 1)
                n2++;
            n2 /= 2;
            num /= 2;
            if (n1 != n2)
                round++;
        }
        System.out.println(round);
    }
}
