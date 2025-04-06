import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static class Shark {
        int size = 2;
        int feed = 0;
        int time = 0;
        List<int[]> fishes;

        int[] pos = new int[2]; // 상어의 위치
        Shark(int x, int y) {
            pos[0] = x;
            pos[1] = y;
        }

        void eat(int[][] field) {
            // 가장 위쪽의 먹이를 구함
            int top_row = field.length;
            for (int[] e : fishes) {
                top_row = Math.min(e[0], top_row);
            }

            // 그 위쪽들 중에서 가장 왼쪽의 먹이를 구함
            int leftmost = field.length;
            int temptime = 0;
            for (int[] e : fishes) {
                if (e[0] == top_row) {
                    if (e[1] < leftmost) {
                        leftmost = e[1];
                        temptime = e[2];
                    }
                }
            }

            feed++; // 먹고
            field[pos[0]][pos[1]] = 0; // 상어 위치는 0
            pos[0] = top_row; pos[1] = leftmost; // 위치 변경경
            field[top_row][leftmost] = 9; // 먹이 위치는 9
            time += temptime; // 거리만큼 시간 증가

            if (feed == size) { // 먹은 개수가 사이즈와 같다면
                feed = 0; // 먹은 수 초기화
                size++; // 사이즈 증가
            }
        }
    
        int[][] dir = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        boolean search(int[][] field, int n) {
            boolean[][] visit = new boolean[n][n];
            Queue<int[]> q = new ArrayDeque<>();
            fishes = new ArrayList<>();
            int min_step = 1000000000;
            q.add(new int[]{pos[0], pos[1], 0}); // 상어의 위치를 기준으로 탐색 시작, 시간은 0초
            visit[pos[0]][pos[1]] = true;
            while (!q.isEmpty()) {
                int[] p = q.poll();
                int x = p[0];
                int y = p[1];
                int step = p[2];

                for (int i = 0; i < 4; i++) {
                    int dx = x + dir[i][0];
                    int dy = y + dir[i][1];
                    if (0 <= dx && dx < n && 0 <= dy && dy < n // 맵 밖을 나가지 않으면서
                        && field[dx][dy] <= size && visit[dx][dy] == false) { // 지나갈 수 있을 때
                        q.add(new int[]{dx, dy, step + 1});
                        visit[dx][dy] = true;
                        
                        if (0 < field[dx][dy] && field[dx][dy] < size) {// 먹을 수 있는 물고기 존재
                            min_step = Math.min(min_step, step + 1); // 같은 거리의 물고기만 담길 수 있도록 조정정
                            if (step + 1 > min_step)
                                break;
                            fishes.add(new int[]{dx, dy, step + 1});
                        }
                    }
                }
            }
            if (fishes.isEmpty())
                return false; // 탐색 실패
            return true; // 탐색 성공
        }
    }

    static Shark shark;
    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());
        int[][] field = createField(size);
        simulate(field, size);
    }

    public static void simulate(int[][] field, int size) {
        while (shark.search(field, size)) {
            shark.eat(field);
        }
        System.out.println(shark.time);
    }

    public static int[][] createField(int size) throws IOException {
        int[][] field = new int[size][size];

        for (int i = 0; i < size; i++) {
            String[] in = br.readLine().split(" ");
            for (int j = 0; j < size; j++) {
                int value = Integer.parseInt(in[j]);
                field[i][j] = value;
                if (value == 9)
                    shark = new Shark(i, j);
            }
        }
        return field;
    }
}