import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int num = Integer.parseInt(in[0]);
    
        ArrayList<Long> arr = new ArrayList<>();
        for (int i = 1; i < in.length; i++) {
            String reversed = new StringBuilder(in[i]).reverse().toString(); // 문자열 뒤집기
            arr.add(Long.parseLong(reversed));
        }
        while (arr.size() != num) {
            in = br.readLine().split(" "); // 마지막 문자열을 널 문자열로 판단하므로 이를 제외
            for (String numString : in) {
                if (!numString.isEmpty()) {
                    String reversed = new StringBuilder(numString).reverse().toString();
                    arr.add(Long.parseLong(reversed));
                }
            }
        }
        
        arr.sort(null);
        StringBuilder sb = new StringBuilder();
        for (Long value : arr)
            sb.append(value).append("\n");
        System.out.print(sb);
        br.close();
    }
}