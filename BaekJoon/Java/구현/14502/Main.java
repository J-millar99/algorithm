import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int result = 0;

    // 맵 출력 함수
    // public static void printMap(char[][] map) {
    //     System.out.println("=============");
    //     for (int i = 0; i < map.length; i++) {
    //         for (int j = 0; j < map[0].length; j++)
    //             System.out.print(map[i][j] + " ");
    //         System.out.println();
    //     }
    // },

    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        int n, m;

        // 벽을 세울 공간 탐색을 위한 배열
        ArrayList<int[]> a = new ArrayList<>();
    
        // 바이러스의 초기 위치 저장 큐
        Queue<int[]> q = new ArrayDeque<>();

        // 맵의 크기 입력
        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);

        // 맵 생성
        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = line[j].charAt(0);
                if (map[i][j] == '0') // 만약 공간 좌표라면
                    a.add(new int[] { i, j }); // 벽이 세워질 수 있는 좌표이므로 저장
                if (map[i][j] == '2') // 만약 바이러스 좌표라면
                    q.add(new int[] { i, j }); // 너비 우선 탐색을 위해 좌표 저장
            }
        }

        // 입력받은 맵 출력 0: 공간, 1: 벽, 2: 바이러스
        // printMap(map);

        /*
         * 브루트포스로 벽 세우기
         * 바이러스 퍼트리기
         * 최대 공간 수 세기
         */
        simulate(map, a, q);
        System.out.println(result);
        br.close();
    }

    public static void simulate(char[][] map, ArrayList<int[]> a, Queue<int[]> q) {
        for (int i = 0; i < a.size(); i++) {
            int[] pos1 = a.get(i);
            map[pos1[0]][pos1[1]] = '1';
            for (int j = i + 1; j < a.size(); j++) {
                int[] pos2 = a.get(j);
                map[pos2[0]][pos2[1]] = '1';
                for (int k = j + 1; k < a.size(); k++) {
                    int[] pos3 = a.get(k);
                    map[pos3[0]][pos3[1]] = '1';
                    char[][] src = copyMap(map);
                    virus(src, q);
                    countSpace(src);
                    map[pos3[0]][pos3[1]] = '0'; // 이전 벽 좌표(pos1)를 초기화
                }
                map[pos2[0]][pos2[1]] = '0'; // 이전 벽 좌표(pos2)를 초기화
            }
            map[pos1[0]][pos1[1]] = '0'; // 이전 벽 좌표(pos1)를 초기화
        }
    }

    public static void virus(char[][] src, Queue<int[]> q) {
         // 상하좌우 4방향
        int[][] d = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        Queue<int[]> copyQueue = new ArrayDeque<>(q);

        // 큐를 순회하며 너비 우선 탐색
        while (!copyQueue.isEmpty()) {
            int[] loc = copyQueue.poll();
            for (int i = 0; i < 4; i++) {
                int dx = loc[0] + d[i][0];
                int dy = loc[1] + d[i][1];
                if (dx < 0 || dx >= src.length || dy < 0 || dy >= src[0].length || src[dx][dy] != '0')
                    continue;
                src[dx][dy] = '2';
                copyQueue.add(new int[]{dx, dy});
            }
        }
    }

    // 원본 맵을 복사하여 시뮬레이션으로 사용
    public static char[][] copyMap(char[][] map) {
        char[][] src = new char[map.length][map[0].length];

        for (int i = 0; i < map.length; i++)
            for (int j = 0; j < map[0].length; j++)
                src[i][j] = map[i][j];
        return src;
    }

    // 맵의 공간 세기
    public static void countSpace(char[][] src) {
        int count = 0;

        for (int i = 0; i < src.length; i++) {
            for (int j = 0; j < src[0].length; j++)
                if (src[i][j] == '0')
                    ++count;
        }
        if (result < count)
            result = count;
    }
}