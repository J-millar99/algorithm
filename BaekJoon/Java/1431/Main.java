import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static class SerialNumber {
        String str;
        int sum;
        int length;
        SerialNumber(String str, int sum, int length) {
            this.str = str;
            this.sum = sum;
            this.length = length;
        }

    }
    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());

        List<SerialNumber> arr = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            String in = br.readLine();
            int cal = digitSum(in);
            arr.add(new SerialNumber(in, cal, in.length()));
        }

        arr.sort(Comparator.comparing((SerialNumber s) -> s.length) // 짧은 길이 순
                .thenComparing((SerialNumber s) -> s.sum) // 각 자리수의 합
                .thenComparing((SerialNumber s) -> s.str)); // 사전 순
        
        for (SerialNumber s : arr) {
            sb.append(s.str).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    public static int digitSum(String str) {
        int sum = 0;
        for (char ch : str.toCharArray()) {
            if (ch > '0' && ch <= '9')
                sum += (int) ch - '0';
        }
        return sum;
    }
}