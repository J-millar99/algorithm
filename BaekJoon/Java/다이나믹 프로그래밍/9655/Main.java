import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        if (num % 2 == 0)
            System.out.println("CY");
        else
            System.out.println("SK");
        br.close();
    }
    /*
     * 1 -> SK
     * 2 -> CK
     * 3 -> SK
     * 4 -> CK : 1, 3을 말한 사람이 패배
     * 5 -> SK : 3을 말한 사람이 승리
     * 6 -> CK : 4를 말한 사람이 승리
     * 결국 홀 짝으로 구분
     */
}