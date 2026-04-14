import java.io.*;


public class Main {
    static StringBuilder sb;
    static boolean[] primeArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tries = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        makeSifter();
        for (int i = 0; i < tries; i++) {
            int num = Integer.parseInt(br.readLine());
            solution(num);
        }

        System.out.print(sb);
        br.close();
    }

    public static void solution(int target) {
        if (target == 4) {
            sb.append(2 + " " + 2 + "\n");
            return;
        }

        int flag = 0;
        int b = (target / 2) + 1;
        if ((target / 2) % 2 != 0) // 타겟의 절반이 홀수라면 홀수를 유지
            b = (target / 2);
        int a = b;
        while (a > 2 && b < 10001) {
            if (primeArr[a] == false && primeArr[b] == false && a + b == target) {
                sb.append(a + " " + b + "\n");
                break;
            }
            flag ^= 1;
            if (flag == 1)
                a -= 2;
            else
                b += 2;
        }
    }


    public static void makeSifter() {
        // 소수이면 false, 소수가 아니면 true
        primeArr = new boolean[10001];
        primeArr[0] = true; primeArr[1] = true;
        for (int i = 2; i <= 100; i++) {
            if (primeArr[i] == false)
                for (int j = i * i; j < primeArr.length; j += i) // i * 2 가 아니라 i * i인 이유는 이전의 i가 곱하기 2의 자리를 대신해줌 예를들어, 3 * 2는 2 * 3에서 해결되었음.
                    primeArr[j] = true;
        }
    }
}