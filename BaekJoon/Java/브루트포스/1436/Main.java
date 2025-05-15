import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int start = 666;
        int n = Integer.parseInt(br.readLine());

        int idx = 0;
        while (true) {
            String s = String.valueOf(start);
            if (s.contains("666")) {
                idx++;
                if (idx == n)
                    break;
            }
            ++start;
        }
        System.out.println(start);
        br.close();
    }
}