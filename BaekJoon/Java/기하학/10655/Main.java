import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());

        List<int[]> checkPoint = new LinkedList<>();
        for (int i = 0; i < num; i++) {
            String[] in = br.readLine().split(" ");
            checkPoint.add(new int[]{
                Integer.parseInt(in[0]),
                Integer.parseInt(in[1])
            });
        }
        solution(checkPoint, num);
        br.close();
    }

    public static void solution(List<int[]> cp, int num) {
        int idx = 1;
        int result = 0;
    
        while (idx != num - 1) {
            int total = 0;
            int x = cp.get(idx)[0];
            int y = cp.get(idx)[1];
            cp.remove(idx);
            for (int i = 0; i < num - 2; i++) {
                int distance = 
                    Math.abs(cp.get(i)[0] - cp.get(i+1)[0])
                    + Math.abs(cp.get(i)[1] - cp.get(i+1)[1]);
                total += distance;
            }
            result = Math.max(total, result);
            cp.add(idx, new int[]{x, y});
            idx++;
        }
        System.out.println(result);
    }
}