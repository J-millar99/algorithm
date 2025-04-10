import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int num, len;
    static int count;
    public static void main(String[] args) throws IOException {
        num = Integer.parseInt(br.readLine());
        len = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int idx;
        for (idx = 0; idx < len; idx++) {
            if (str.charAt(idx) == 'I' && str.charAt(idx + 1) == 'O')
                break;
        }

        count = 0;
        while (idx < len) {
            checkOI(str, idx);
            int i = 0;
            for (i = idx + 1; i + 1 < len; i++) {
                if (str.charAt(i) == 'I' && str.charAt(i + 1) == 'O')
                    break;
            }
            idx = i;
        }
        System.out.println(count);
        br.close();
    }

    public static void checkOI(String str, int idx) {
        if (idx + num * 2 >= len)
            return;
        int cnt = 0;
        for (int i = 1; i <= num * 2; i++) {
            int index = idx + i;
            if (i % 2 == 1 && str.charAt(index) == 'O')
                ++cnt;
            else if (i % 2 == 0 && str.charAt(index) == 'I')
                ++cnt;
            else
                break;
        }
        if (cnt == num * 2)
            ++count;
    }
}