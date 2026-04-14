import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());

        int[] posX = new int[num];
        int[] posY = new int[num];
        for (int i = 0; i < num; i++) {
            String[] in = br.readLine().split(" ");
            posX[i] = Integer.parseInt(in[0]);
            posY[i] = Integer.parseInt(in[1]);
        }

        Arrays.sort(posX);
        Arrays.sort(posY);


        // 중앙값 찾기 (홀수 개수: 중간값, 짝수 개수: 중간 두 값 중 아무거나)
        int medianX = posX[num / 2];
        int medianY = posY[num / 2];

        // 총 거리 계산
        long totalDistance = 0;
        for (int i = 0; i < num; i++) {
            totalDistance += Math.abs(posX[i] - medianX);
            totalDistance += Math.abs(posY[i] - medianY);
        }

        System.out.println(totalDistance);
        br.close();
    }
    

}