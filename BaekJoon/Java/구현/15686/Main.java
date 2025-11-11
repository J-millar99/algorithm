import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static List<Pos> chick = new ArrayList<>(); // 가게의 위치
    static List<Pos> house = new ArrayList<>(); // 집의 위치
    static List<Pos> remain = new ArrayList<>(); // 남긴 프렌차이즈 위치

    static int n; // 맵 크기
    static int m; // 남길 가게 수

    static int answer = Integer.MAX_VALUE;
    // 좌표 클래스
    public static class Pos {
        public int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
    }

    // 도시의 치킨 거리를 구하는 함수
    public static int getDistance(List<Pos> param) {
        int distance = 0; // 도시의 치킨 거리

        for (Pos housePos : house) { // 한 집에 대하여
            int min = Integer.MAX_VALUE;
            for (Pos chickPos : param) { // 모든 치킨 집과의 거리 계산으로 최솟값을 구함
                int num = Math.abs(housePos.x - chickPos.x)
                            + Math.abs(housePos.y - chickPos.y);
                min = Math.min(min, num);
            }
            distance += min;
        }
        return distance;
    }

    public static void dfs(int s, int depth) {
        if (depth == 0) {
            int result = getDistance(remain);
            answer = Math.min(answer, result);
            return;
        }

        for (int i = s; i < chick.size(); i++) {
            Pos pos = chick.get(i);
            remain.add(pos);
            dfs(i + 1, depth - 1);
            remain.remove(remain.size() - 1); // 마지막 가게를 제거
        }
    }

    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");

        n = Integer.parseInt(in[0]); // 맵 크기
        m = Integer.parseInt(in[1]); // 남길 가게 수

        for (int i = 1; i <= n; i++) {
            in = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                char ch = in[j - 1].charAt(0);
                if (ch == '1') // 집이라면
                    house.add(new Pos(i, j));
                else if (ch == '2') // 가게라면
                    chick.add(new Pos(i, j));
            }
        }

        dfs(0, m);
        System.out.println(answer);
        br.close();
    }
}