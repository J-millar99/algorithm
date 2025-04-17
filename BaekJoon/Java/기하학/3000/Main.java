import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        int[] px = new int[num];
        int[] py = new int[num];
        int[] arrx = new int[100001];
        int[] arry = new int[100001];
        
        // 모든 점을 배열과 해시셋에 저장
        for (int i = 0; i < num; i++) {
            String[] in = br.readLine().split(" ");
            px[i] = Integer.parseInt(in[0]);
            py[i] = Integer.parseInt(in[1]);
            arrx[px[i]]++;
            arry[py[i]]++;
        }

        long count = 0;
        for (int i = 0; i < num; i++) {
            long countx = arrx[px[i]];
            long county = arry[py[i]];
            if (countx > 1 && county > 1)
                // 1을 빼주는 이유는 직각에 해당하는 px[i], py[i]를 제외하고 x축에서 1개 y축에서 한 개 뽑아야 하기 때문이다
                count += (countx - 1) * (county - 1);
        }
        System.out.println(count);
        br.close();
    }
}