import java.io.*;

public class Main {
    /*
        1. 해당 수가 몇 번째 빗금에 속하는지 확인
        2. 빗금 수가 짝수 혹은 홀수에 따라 방향을 결정
        3. 방향에 따른 분자, 분모를 남은 n값으로 조정
    */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sectionNumber = 1;
        while (true) {
            if (n - sectionNumber > 0) {
                n -= sectionNumber;
                sectionNumber++;
            } else
                break;
        }

        int numerator;
        int denominator;
        if (sectionNumber % 2 == 0) {
            numerator = n;
            denominator = sectionNumber - n + 1;
        } else {
            numerator = sectionNumber - n + 1;;
            denominator = n;
        }
        System.out.println(numerator + "/" + denominator);
        br.close();
    }
}