import java.io.*;
import java.util.*;

public class Main {

    static class Pair {
        int dir, length;
        Pair(int dir, int length) {
            this.dir = dir;
            this.length = length;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Pair> lst = new ArrayList<>();

        int[] flag = new int[5];
        for (int i = 0; i < 6; i++) {
            String[] input = br.readLine().split(" ");
            int dir = Integer.parseInt(input[0]);
            int length = Integer.parseInt(input[1]);
            Pair pair = new Pair(dir, length);
            flag[dir] ^= 1;
            lst.add(pair);
        }

        while (true) {
            Pair p1 = lst.get(0);
            Pair p2 = lst.get(5);
            if (flag[p1.dir] == 1 && flag[p2.dir] == 1)
                break;
            Collections.rotate(lst, 1);
        }

        int area = lst.get(0).length * lst.get(5).length
                     - lst.get(2).length * lst.get(3).length;
        System.out.println(area * n);
        br.close();
    }
}
