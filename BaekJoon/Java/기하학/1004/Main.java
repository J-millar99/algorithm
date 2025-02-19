import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    static class Pos {
        int x, y;
        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Planet {
        int x, y, r;
        Planet(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int tries = Integer.parseInt(br.readLine());

        for (int i = 0; i < tries; i++)
            inputPlanetCordinates();
        br.close();
    }

    public static void inputPlanetCordinates() throws IOException {
        String[] pos = br.readLine().split(" ");
        Pos s = new Pos(Integer.parseInt(pos[0]), Integer.parseInt(pos[1]));
        Pos d = new Pos(Integer.parseInt(pos[2]), Integer.parseInt(pos[3]));

        int num = Integer.parseInt(br.readLine());
        List<Planet> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            int r = Integer.parseInt(input[2]);
            Planet p = new Planet(x, y, r);
            list.add(p);
        }
        System.out.println(tarvel(list, s, d));
    }
    
    public static int tarvel(List<Planet> list, Pos s, Pos d) {
        int count = 0;
        for (Planet p : list) {
            int flag = 0;
            double len1 = Math.sqrt(Math.pow(p.x - s.x, 2) + Math.pow(p.y - s.y, 2));
            double len2 =  Math.sqrt(Math.pow(p.x - d.x, 2) + Math.pow(p.y - d.y, 2));
            if (len1 > p.r) // 출발 지점은 행성 내에 없음
                flag++;
            if (len2 > p.r) // 도착 지점은 행성 내에 없음
                flag++;
            if (flag % 2 == 1) // 진입/이탈이 이루어짐
                count++;
        }
        return count;
    }
}
