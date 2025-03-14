import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String in = br.readLine();
        System.out.println(solution(in));
        br.close();
    }

    public static String solution(String in) {
        int[] number = new int[10]; // 0 ~ 9 맵핑
        int sum = 0;
        for (int i = 0; i < in.length(); i++) {
            int ch = in.charAt(i) - '0';
            number[ch] += 1;
            sum += ch;
        }
        // 수는 0으로 시작하지 않음
        if (!(sum % 3 == 0 && number[0] > 0)) // 3으로 나눠지면서 0이 하나라도 있어야 함
            return "-1";

        String result = "";
        for (int i = 9; i >= 0; i--) {
            if (number[i] > 0) {
                for (int j = 0; j < number[i]; j++) {
                    result += String.valueOf(i);
                }
            }
        }
        return result;
    }
}