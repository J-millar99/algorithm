import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        
        int k = 0;
        int p = 0;
        
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            
            if (c == 'K') {
                // K가 나오면 P를 외치는 개구리가 있으면 하나 줄이고, 아니면 K 개구리 추가
                if (p > 0) {
                    p--;
                }
                k++;
            } else { // c == 'P'
                // P가 나오면 K를 외치는 개구리가 있으면 하나 줄이고, 아니면 P 개구리 추가
                if (k > 0) {
                    k--;
                }
                p++;
            }
        }
        
        // 최종적으로 남아있는 개구리의 총 수가 답
        System.out.println(k + p);
        br.close();
    }
}