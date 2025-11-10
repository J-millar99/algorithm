import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, c;
    static int[] loc;
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        
        n = Integer.parseInt(in[0]); // 집의 개수
        c = Integer.parseInt(in[1]); // 공유기 개수
        
        loc = new int[n]; // 집의 위치 배열
        for (int i = 0; i < n; i++) { // 집의 위치를 입력
            int l = Integer.parseInt(br.readLine());
            loc[i] = l;
        }

        Arrays.sort(loc); // 이분탐색을 위한 정렬

        int start = 1;
        int end = loc[n - 1] - loc[0];
        int answer = 1;
        while(start <= end) {
            int mid = (start + end) / 2;

            // 공유기를 모두 설치했으면 거리를 약간 더 늘려봄
            if (canInstall(mid)) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(answer);
    }

    public static boolean canInstall(int distance) {
        // 첫 집에는 공유기를 무조건 설치
        int count = 1;
        int lastPosition = loc[0];

        // 다음 집을 차례로 비교하면서 최대 거리를 만족하는 간격으로 설치 요구 개수를 만족하는지 확인
        for (int i = 1; i < n; i++) {
            if (distance <= loc[i] - lastPosition) {
                count++;
                lastPosition = loc[i];
            }
        }
    
        return count >= c;
    }
}
