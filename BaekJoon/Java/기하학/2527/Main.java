import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        for (int tries = 0; tries < 4; tries++) {
            String[] in = br.readLine().split(" ");

            int[] square1 = new int[4];
            for (int i = 0; i < 4; i++) square1[i] = Integer.parseInt(in[i]);

            int[] square2 = new int[4];
            for (int i = 0; i < 4; i++) square2[i] = Integer.parseInt(in[i + 4]);

            solution(square1, square2);
        }
        System.out.print(sb);
        br.close();
    }

    public static void solution(int[] square1, int[] square2) {
        if (typeA(square1, square2))
            sb.append("a");
        else if (typeB(square1, square2))
            sb.append("b");
        else if (typeC(square1, square2))
            sb.append("c");
        else
            sb.append("d");
        sb.append("\n");
    }

    public static boolean typeA(int[] square1, int[] square2) {
        // 1. 오른쪽 위 겹침
        if (square1[0] <= square2[0] && square1[1] <= square2[1] &&
            square2[0] < square1[2] && square2[1] < square1[3])
            return true;
        // 2. 왼쪽 아래 겹침
        if (square1[2] >= square2[2] && square1[3] >= square2[3] &&
            square1[0] < square2[2] && square1[1] < square2[3])
            return true;

        // 3. 오른쪽 아래 겹침
        if (square1[0] <= square2[0] && square1[3] >= square2[3] &&
            square1[2] > square2[0] && square1[1] < square2[3])
            return true;

        // 4. 왼쪽 위 겹침
        if (square1[0] < square2[2] && square2[1] < square1[3] &&
            square1[2] >= square2[2] && square1[1] <= square2[1])
            return true;

        if (square1[0] <= square2[0] && square2[0] < square1[2] &&
            square2[1] <= square1[1] && square2[3] >= square1[3])
            return true;
        if (square1[0] < square2[0] && square2[0] <= square1[2] &&
            square2[1] <= square1[1] && square2[3] >= square1[3])
            return true;
        return false;
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