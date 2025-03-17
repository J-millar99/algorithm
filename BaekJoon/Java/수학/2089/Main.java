import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        if (num == 0)
            sb.append("0");
        solution(num, -2);
        System.out.println(sb);
        br.close();
    }

    public static void solution(int num, int base) {
        if (num == 0)
            return;
            
        int remainder = num % base;
        
        // -2진법에서의 특별한 처리
        if (remainder == -1) {
            remainder = 1;
            num = num / base + 1;
        } else {
            num = num / base;
        }
        
        solution(num, base);
        sb.append(remainder);
    }
}
