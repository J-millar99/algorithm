import java.io.*;

public class Main {
    static StringBuilder sb;
    static boolean[] primeArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        makeSifter();

        int target = 0;
        while (true) {
            target = Integer.parseInt(br.readLine());
            if (target == 0)
                break;
            solution(target);
        }

        System.out.print(sb);
        br.close();
    }

    public static void solution(int target) {
        int b = target - 1;
        while (b >= 3) {
            if (primeArr[b] == true) {
                b -= 2;
                continue;
            }
            int a = 3;
            while (true) {
                if (primeArr[a] == true) {
                    a += 2;
                    continue;
                }
                if (a + b == target) {
                    sb.append(target + " = " + a + " + " + b + "\n");
                    return ;
                } else if (a + b > target)
                    break;
                a += 2;
            }
            b -= 2;
        }
        sb.append("Goldbach's conjecture is wrong.\n");
    }

    public static void makeSifter() {
        // 소수이면 false, 소수가 아니면 true
        primeArr = new boolean[10000001];
        primeArr[0] = true; primeArr[1] = true;
        for (int i = 2; i <= 1000; i++) {
            if (primeArr[i] == false)
                for (int j = i * i; j < primeArr.length; j += i) // i * 2 가 아니라 i * i인 이유는 이전의 i가 곱하기 2의 자리를 대신해줌 예를들어, 3 * 2는 2 * 3에서 해결되었음.
                    primeArr[j] = true;
        }
    }
}