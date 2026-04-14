import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        int[] square1 = new int[4];
        for (int i = 0; i < 4; i++) square1[i] = Integer.parseInt(in[i]);

        in = br.readLine().split(" ");
        int[] square2 = new int[4];
        for (int i = 0; i < 4; i++) square2[i] = Integer.parseInt(in[i]);

        solution(square1, square2);
        System.out.print(sb);
        br.close();
    }

    public static void solution(int[] square1, int[] square2) {
        if (typeA(square1, square2) || typeA(square2, square1))
            sb.append("FACE");
        else if (typeB(square1, square2) || typeB(square2, square1))
            sb.append("LINE");
        else if (typeC(square1, square2) || typeC(square2, square1))
            sb.append("POINT");
        else
            sb.append("NULL");
        sb.append("\n");
    }

    public static boolean typeA(int[] square1, int[] square2) {
        // 두 직사각형이 겹치는 경우
        return !(square1[2] <= square2[0] ||    // rect1이 rect2의 왼쪽에 있음
        square1[0] >= square2[2] ||    // rect1이 rect2의 오른쪽에 있음
        square1[3] <= square2[1] ||    // rect1이 rect2의 아래쪽에 있음
        square1[1] >= square2[3]);     // rect1이 rect2의 위쪽에 있음
    }

    public static boolean typeB(int[] square1, int[] square2) {
        // 1. 아래에서 접함
        if (square1[1] == square2[3]) {
            if (square1[0] <= square2[0] && square2[0] < square1[2]
                || square1[0] < square2[2] && square2[2] <= square1[2])
                return true;
        }
        
        // 2. 위에서 접함
        if (square1[3] == square2[1]) {
            if (square1[0] <= square2[0] && square2[0] < square1[2]
                || square1[0] < square2[2] && square2[2] <= square1[2])
                return true;
        }

        // 3. 왼쪽에서 접함
        if (square1[0] == square2[2]) {
            if (square1[1] <= square2[1] && square2[1] < square1[3]
                || square1[1] < square2[3] && square2[3] <= square1[3])
                return true;
        }

        // 4. 오른쪽에서 접함
        if (square1[2] == square2[0]) {
            if (square1[1] <= square2[1] && square2[1] < square1[3]
                || square1[1] < square2[3] && square2[3] <= square1[3])
                return true;
        }
        return false;
    }

    public static boolean typeC(int[] square1, int[] square2) {
        // 1. 왼쪽 아래
        if (square1[0] == square2[2] && square1[1] == square2[3])
            return true;
        
        // 2. 오른쪽 아래
        if (square1[2] == square2[0] && square1[1] == square2[3])
            return true;
        
        // 3. 왼쪽 위
        if (square1[0] == square2[2] && square1[3] == square2[1])
            return true;

        // 4. 오른쪽 위
        if (square1[2] == square2[0] && square1[3] == square2[1])
            return true;
        return false;        
    }
}