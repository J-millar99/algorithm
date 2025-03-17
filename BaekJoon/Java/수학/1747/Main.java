import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int limit = 1003002;
        boolean[] arr = new boolean[limit];
        arr[0] = arr[1] = true;
        int num = Integer.parseInt(br.readLine());

        for (int i = 2; i * i < limit; i++) {
            if (!arr[i]) {
                // i가 소수라면, i의 배수들을 모두 소수가 아닌 것으로 표시
                // i*i부터 시작하는 이유: i*2, i*3, ..., i*(i-1)은 이미 이전 소수들에 의해 처리됨
                for (int j = i * i; j < limit; j += i) {
                    arr[j] = true;
                }
            }
        }

        for (int i = num; i < limit; i++) {
            if (!arr[i] && isPalindrome(i)) {
                System.out.println(i);
                break;
            }
        }
        br.close();
    }

    public static boolean isPalindrome(int num) {
        String str = String.valueOf(num);
        int len = str.length();
        for (int j = 0; j < len / 2; j++) {
            if (str.charAt(j) != str.charAt(len - j - 1))
                return false;
        }
        return true;
    }
}