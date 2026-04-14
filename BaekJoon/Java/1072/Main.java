import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");

        int x = Integer.parseInt(in[0]);
        int y = Integer.parseInt(in[1]);

        System.out.println(solution(x, y));
        br.close();
    }

    public static int getWinRate(int match, int win) {
        // 소수점 3자리 이하 손실, 그러나 정수 연산만 하므로 정확도 보장
        int result = (int) ((long) win * 100 / match);
        // 소수점을 손실하지 않지만 정확도에 오차가 존재
        // int result = (int) (((double) y / (double) x) * 100);
        return result;
    }

    public static int solution(int x, int y) {
        int winRate = getWinRate(x, y);
        int s = 0;
        int e = x;

        int result = 0;
        while (s <= e) {
            int m = (s + e) / 2;
            int newRate = getWinRate(x + m, y + m);
            if (winRate == newRate) { // 승 수를 더 올려야 함
                s = m + 1;
                result = m;
            }
            else { // 승 수를 덜 해도 됨
                e = m - 1;
            }
        }
        if (result == x)
            return -1;
        return result + 1;
    }
}
