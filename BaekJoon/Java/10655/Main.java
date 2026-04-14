import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());

        int[][] checkPoint = new int[num][2];
        for (int i = 0; i < num; i++) {
            String[] in = br.readLine().split(" ");
            checkPoint[i][0] = Integer.parseInt(in[0]);
            checkPoint[i][1] = Integer.parseInt(in[1]);
        }
        solution(checkPoint, num);
        br.close();
    }

    public static void solution(int[][] cp, int num) {
        // 기본 거리 계산 (모든 체크포인트 방문)
        int fullDistance = 0;
        for (int i = 0; i < num - 1; i++) {
            fullDistance += Math.abs(cp[i][0] - cp[i+1][0]) + Math.abs(cp[i][1] - cp[i+1][1]);
        }
        
        // 최소 거리 초기화
        int result = fullDistance;
        
        // 각 체크포인트(첫 번째와 마지막을 제외)를 건너뛰었을 때 거리 계산
        for (int skipIdx = 1; skipIdx < num - 1; skipIdx++) {
            // 건너뛰는 체크포인트의 전후 거리
            int skipDistance = Math.abs(cp[skipIdx-1][0] - cp[skipIdx][0]) + 
                               Math.abs(cp[skipIdx-1][1] - cp[skipIdx][1]) +
                               Math.abs(cp[skipIdx][0] - cp[skipIdx+1][0]) + 
                               Math.abs(cp[skipIdx][1] - cp[skipIdx+1][1]);
            
            // 건너뛰었을 때 추가되는 새 거리
            int newConnection = Math.abs(cp[skipIdx-1][0] - cp[skipIdx+1][0]) + 
                                Math.abs(cp[skipIdx-1][1] - cp[skipIdx+1][1]);
            
            // 총 거리 업데이트
            int newDistance = fullDistance - skipDistance + newConnection;
            
            // 최소값 업데이트
            result = Math.min(result, newDistance);
        }
        
        System.out.println(result);
    }
}