import java.io.*;
import java.util.*;

public class Main {
    static class Man {
        int weight, height;
        int rank;
        Man(int weight, int height) {
            this.weight = weight;
            this.height = height;
            rank = 1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Man> lst = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int weight = Integer.parseInt(input[0]);
            int height = Integer.parseInt(input[1]);
            lst.add(new Man(weight, height));
        }

        for (int i = 0; i < n; i++) {
            Man man = lst.get(i);
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                Man op = lst.get(j);
                if (man.height < op.height && man.weight < op.weight)
                    man.rank++;
            }
        }
        
        for (Man man : lst)
            System.out.print(man.rank + " ");
        System.out.println();
        br.close();
    }
}
