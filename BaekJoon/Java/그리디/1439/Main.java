import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = br.readLine();

        int zcnt = 0; // 0의 개수
        int ocnt = 0; // 1의 개수
        int idx = 0;
        int len = in.length();
        while (idx != len) {
            char ch = in.charAt(idx);
            idx++;
            if (ch == '0') {
                ++zcnt;
                while (idx != len && in.charAt(idx) == '0') {
                    idx++;
                }
            }
            else if (ch == '1') {
                ++ocnt;
                while (idx != len && in.charAt(idx) == '1') {
                    idx++;
                }
            }
        }

        System.out.println(Math.min(zcnt, ocnt));
        br.close();
    }
}
