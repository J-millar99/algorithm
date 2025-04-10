import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        int len = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int idx = 0;
        int count = 0;
        int total = 0;
        while (idx + 2 < len) {
            if (str.charAt(idx) == 'I' && str.charAt(idx + 1) == 'O' && str.charAt(idx + 2) == 'I') {
                idx += 2;
                count++;
                if (count == num) {
                    total++;
                    count--;
                }
            } else {
                idx += 1;
                count = 0;
            }

        }
        System.out.println(total);
        br.close();
    }
}