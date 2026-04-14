import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int tries = Integer.parseInt(br.readLine());
        for (int i = 0; i < tries; i++) {
            int num = Integer.parseInt(br.readLine());
            solution(num); 
        }
        System.out.print(sb);
        br.close();
    }

    public static void solution(int num) {
        int[] divisor = new int[num + 1];

        int div = 2;
        int temp = num;
        while (temp != 1) { // temp이 1이 될 때 까지
            while (temp % div == 0) { // div로 나누어지면
                temp /= div; // 나눌만큼 나눔
                divisor[div] += 1;
            }
            ++div;
        }

        for (int i = 2; i <= num; i++) { // 약수 배열을 순회하며
            if (divisor[i] != 0) {   // 약수가 존재하면
                sb.append(i)    // 해당 약수와
                .append(" ")
                .append(divisor[i]) // 개수를 출력
                .append("\n");
            }
        }
    }
}