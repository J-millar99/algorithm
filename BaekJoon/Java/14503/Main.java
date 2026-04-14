import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // 북 동 남 서 방향의 정면 방향으로 매핑
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        int row = Integer.parseInt(in[0]);
        int col = Integer.parseInt(in[1]);

        in = br.readLine().split(" ");

        int[] robot = new int[3]; // r, c, d
        robot[0] = Integer.parseInt(in[0]);
        robot[1] = Integer.parseInt(in[1]);
        robot[2] = Integer.parseInt(in[2]); // 북0 동1 남2 서3

        char[][] field = new char[row][col];
        for (int i = 0; i < row; i++) {
            in = br.readLine().split(" ");
            for (int j = 0; j < col; j++) {
                field[i][j] = in[j].charAt(0);
            }
        }
        simulation(row, col, field, robot);
        br.close();
    }

    public static void simulation(int row, int col, char[][] field, int[] robot) {
        int count = 0;
        while (true) {
            int x, y, d;
            int rotate = 0;

            // 로봇 청소기의 현재 위치를 x, y로 방향을 d로 표현
            x = robot[0];
            y = robot[1];
            d = robot[2];

            // 로봇 청소기의 처음 위치는 항상 빈 칸
            if (field[x][y] == '0') { // 청소되지 않은 칸
                count++;    // 청소 카운트
                field[x][y] = '2'; // 청소된 칸을 '2'로 표현
            }

            // 로봇의 다음 청소 영역 탐색
            while (rotate < 4) {
                // 반시계 회전
                d--;
                if (d < 0)
                    d = 3;
                robot[2] = d;
                // 방향을 기준으로 전방 칸 청소 여부 확인
                int dx = x + dir[d][0];
                int dy = y + dir[d][1];

                // 필드 바깥이 아니면서, 청소되지 않은 빈칸이라면 위치를 수정
                if (move(row, col, dx, dy) && field[dx][dy] == '0') {
                    robot[0] = dx;
                    robot[1] = dy;
                    break;
                } else { // 청소된 빈칸이라면 방향을 반시계로 회전
                    rotate++;
                }
            }

            if (rotate == 4) {
                // 북0 동1 남2 서3 기준으로 뒤 좌표를 구함
                int back = (d + 2) % 4;
                int dx = x + dir[back][0];
                int dy = y + dir[back][1];

                // 필드 바깥이 아니면서, 벽이 아니라면 후진
                if (move(row, col, dx, dy) && field[dx][dy] != '1') {
                    robot[0] = dx;
                    robot[1] = dy;
                } else break; // 아니면 작동을 멈춤
            }
        }
        System.out.println(count);
    }

    public static boolean move(int row, int col, int x, int y) {
        if (x < 0 || x >= row || y < 0 || y >= col)
            return false; 
        return true;
    }
}