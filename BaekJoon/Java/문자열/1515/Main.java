import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String input = br.readLine();

        int idx = 0;
        int num = 0;

        while (idx < input.length()) {
            num++; // 1부터 시작
            String numStr = String.valueOf(num);

            for (int i = 0; i < numStr.length(); i++) {
                if (idx < input.length() && numStr.charAt(i) == input.charAt(idx))
                    idx++;
            }
        }
        System.out.println(num);
        br.close();
    }
}