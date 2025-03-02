import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, m, b;
    static int max_height, min_height;
    static int[][] block;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        b = Integer.parseInt(input[2]);
        max_height = 0;     // 땅의 최소 높이가 0
        min_height = 257;   // 땅의 최대 높이가 256
        
        block = new int[n][m];
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            int j = 0;
            for (String str : input) {
                int value = Integer.parseInt(str);
                block[i][j] = value;
                max_height = Math.max(max_height, value);
                min_height = Math.min(min_height, value);
                ++j;
            }
        }
        int time = 0;
        int dtime = 0; // 파는 시간
        int ptime = 0; // 쌓는 시간
        int hvar = 0; // 높이 조정 변수
        int bvar = 0; // 타겟 블럭 변수
        while (max_height != min_height) {
            dtime = digTopTime();
            ptime = pileFloorTime();
            if (ptime == -1 || dtime < ptime) { // 파야함
                b += dtime / 2; // 새롭게 추가된 블럭
                time += dtime;
                bvar = max_height;
                max_height -= 1;
                hvar = -1;
            } else {    // 쌓아야 함
                b -= ptime;
                time += ptime;
                bvar = min_height;
                min_height += 1;
                hvar = +1;
            }
            fixBlockMap(bvar, hvar);
        }
        System.out.println(time + " " + max_height);
        br.close();
    }

    public static int pileFloorTime() {
        int ret = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) // 블럭 맵을 순회하며
                if (block[i][j] == min_height)  // 최하층 블럭 개수 세기
                    ++ret;
        if (ret > b) // 블럭 개수 부족함 pile 불가능
            return -1;
        return ret; // 블럭쌓는데 걸리는 시간
    }

    public static int digTopTime() {
        int ret = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) // 블럭 맵을 순회하며
                if (block[i][j] == max_height)  // 최상층 블럭 개수 세기
                    ++ret;
        return ret * 2; // 블럭 파는데 걸리는 시간
    }

    public static void fixBlockMap(int target_block, int varible) {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (block[i][j] == target_block)
                    block[i][j] += varible;
    }
}
