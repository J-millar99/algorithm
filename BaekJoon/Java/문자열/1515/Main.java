import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String in = br.readLine();
        int len = in.length();

        int origin = 1;
        for (int i = 0; i < len; i++) {
            char ch = in.charAt(i);
            String num = String.valueOf(origin);
            int judge = num.indexOf(ch);
            while (judge == -1) {
                num = String.valueOf(++origin);
                judge = num.indexOf(ch);
            }
            if (i != len - 1)
                origin++;
        }
        System.out.println(origin);
        br.close();
    }
}