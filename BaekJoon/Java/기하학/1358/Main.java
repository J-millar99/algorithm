import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int w, h, x, y, p;
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        w = Integer.parseInt(in[0]);
        h = Integer.parseInt(in[1]);
        x = Integer.parseInt(in[2]);
        y = Integer.parseInt(in[3]);
        p = Integer.parseInt(in[4]);

        int[][] people = new int[p][2];
        for (int i = 0; i < p; i++) {
            in = br.readLine().split(" ");
            people[i][0] = Integer.parseInt(in[0]);
            people[i][1] = Integer.parseInt(in[1]);
        }

        solution(people);
        br.close();
    }

    public static void solution(int[][] people) {
        int count = 0;
        for (int i = 0; i < p; i++) {
            int dx = people[i][0];
            int dy = people[i][1];
            if (inHockeyField(dx, dy))
                count++;
        }
        System.out.println(count);
    }

    public static boolean inHockeyField(int dx, int dy) {
        double r = (double) h / 2;
        // 사각형 안에 존재
        if (x <= dx && dx <= (x + w) && y <= dy && dy <= (y + h))
            return true;
        // 왼쪽 원 안에 존재
        if (Math.sqrt(Math.pow(x - dx, 2) + Math.pow((y + r) - dy , 2)) <= r)
            return true;
        // 오른쪽 원 안에 존재
        if (Math.sqrt(Math.pow((x + w) - dx, 2) + Math.pow((y + r) - dy , 2)) <= r)
            return true;
        return false;
    }
}