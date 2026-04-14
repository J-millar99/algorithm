import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[] flag = {'q', 'u', 'a', 'c', 'k'};
    static int visitCount = 0;
    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        int len = str.length();
        boolean visit[] = new boolean[len];

        int count = 0;
        for (int i = 0; i < len; i++) {
            if (visit[i] == false)
                if (solution(str, visit, len) == true)
                    count++;
        }
        if (visitCount != len)
            System.out.println(-1);
        else
            System.out.println(count);
        br.close();
    }

    public static boolean solution(String str, boolean[] visit, int len) {
        int fdx = 0;
        int[] duckIdx = new int[5];
        boolean duck = false;
        for (int i = 0; i < len; i++) {
            if (!visit[i] && str.charAt(i) == flag[fdx]) { // 방문하지 않았고 발음 알파벳이면
                duckIdx[fdx] = i; // 해당 인덱스를 임시 저장
                fdx++; // 다음 단어 찾도록
            }
            if (fdx == 5) {// 발음이 완성되면
                fdx = 0; // 다시 찾을 수 있도록 초기화
                for (int j = 0; j < 5; j++) {
                    visit[duckIdx[j]] = true; // 발음 알파벳 위치를 방문 처리
                }
                visitCount += 5;
                duck = true;
            }
        }
        return duck;
    }
}