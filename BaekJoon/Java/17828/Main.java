import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        int len = Integer.parseInt(in[0]);
        int price = Integer.parseInt(in[1]);

        System.out.println(solution(price, len));
        br.close();
    }

    public static String solution(int price, int len) {
        int q = price / len; // len자릿수가 q만큼 나눠가짐
        int r = price % len; // 윗자리부터 더해야하는 수
        if ((q == 0 && r < len) || (q == 26 && r != 0) || (q < 0 || q > 26))
            return "!";
        char[] str = new char[len];
        for (int i = 0; i < len; i++) 
            str[i] = 'A';
        
        int init = price - len;
        q = init / 25;
        int idx = 0;
        for (idx = len - 1; idx >= len - q; idx--) 
            str[idx] = 'Z';
        
        r = init % 25;
        if (idx >= 0)
            str[idx] = (char)('A' + r);
        return String.valueOf(str);
    }
}