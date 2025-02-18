import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(getArithmeticSequenceNumber(n));
        br.close();
    }

    static public int getArithmeticSequenceNumber(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isArithmeticSequence(i))
                count += 1;
        }
        return count;
    }

    static public boolean isArithmeticSequence(Integer num) {
        if (num < 100) // 100 이하의 값에서 100을 제외하고 모두 한수
            return true;
        else if (num % 100 != 0) { // 100을 제외한 세 자리수라면
            String numStr = num.toString();
            int first = numStr.charAt(0);
            int middle = numStr.charAt(1);
            int last = numStr.charAt(2);
            if (middle * 2 == first + last)
                return true;
        }
        return false;
    }
}
