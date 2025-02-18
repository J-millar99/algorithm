import java.io.*;
import java.util.*;

public class Main {
    static int row, col;
    static List<List<Character>> map = new ArrayList<>();
    static boolean[][] visit;

    static class Pos {
        int x, y;
        int step;
        Pos(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] mapSize = br.readLine().split(" ");

        // 인덱스로 생각하기 위해 -1
        row = Integer.parseInt(mapSize[0]) - 1;
        col = Integer.parseInt(mapSize[1]) - 1;

        // row, col 크기만큼 방문 배열 추가
        visit = new boolean[row + 1][col + 1];
        
        // 2D맵 생성
        for (int i = 0; i <= row; i++) {
            String line = br.readLine();
            map.add(new ArrayList<Character>());
            for (char ch : line.toCharArray())
                map.get(i).add(ch);
        }

        System.out.println(escapeFromMaze());
        br.close();
    }

    public static int escapeFromMaze() {
        int stepCount = 1;
        Queue<Pos> q = new ArrayDeque<>();
        q.add(new Pos(0, 0, stepCount));
        while (!q.isEmpty()) {
            Pos pos = q.poll();
            stepCount = pos.step;   // 반환을 위해서 현재 걸음 수 기록
            if (pos.x == row && pos.y == col)   // 도착 시 반복문 탈출
                break;
            if (!isPossible(pos.x, pos.y))  // 불가능한 지점 패스
                continue;
            visit[pos.x][pos.y] = true; // 현재 지점 방문처리
            stepCount += 1; // 걸음 수 증가
            q.add(new Pos(pos.x + 1, pos.y, stepCount));    // 4방향 접근
            q.add(new Pos(pos.x, pos.y + 1, stepCount));
            q.add(new Pos(pos.x - 1, pos.y, stepCount));
            q.add(new Pos(pos.x, pos.y - 1, stepCount));
        }
        return stepCount;
    }

    public static boolean isPossible(int x, int y) {
        if (x < 0 || x > row) // 행 범위 초과
            return false;
        else if (y < 0 || y > col) // 열 범위 초과
            return false;
        else if (map.get(x).get(y) == '0') // 갈 수 없는 지점
            return false;
        else if (visit[x][y] == true) // 이미 방문한 지점
            return false;
        return true;
    }
}
