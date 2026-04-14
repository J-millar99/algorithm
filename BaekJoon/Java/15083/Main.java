import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int[][] pos = new int[3][2];
        for (int i = 0; i < 3; i++) {
            String[] in = br.readLine().split(" ");
            pos[i][0] = Integer.parseInt(in[0]);            
            pos[i][1] = Integer.parseInt(in[1]);            
        }
        if (solution(pos))
            System.out.println("WINNER WINNER CHICKEN DINNER!");
        else
            System.out.println("WHERE IS MY CHICKEN?");
        br.close();
    }

    public static boolean solution(int[][] pos) {
        if (pos[0][0] == pos[1][0] && pos[1][0]== pos[2][0])
            return false;
        if (pos[0][1] == pos[1][1] && pos[1][1]== pos[2][1])
            return false;

        // 기울기 a
        double a = ((double)pos[1][1] - pos[0][1]) / ((double)pos[1][0] - pos[0][0]);
        // y절편 구하기
        // y = ax + b
        // b = y - ax
        double b = pos[0][1] - a * pos[0][0];
        if (pos[2][1] == a * pos[2][0] + b)
            return false;
        return true;
    }
}
