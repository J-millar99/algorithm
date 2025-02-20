import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        solution(n, m);
        br.close();
    }

    public static void solution(int n, int m) {
        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> arr = new ArrayList<>();
        int count = 1;

        for(int i = 1; i <= n; i++)
            q.add(i);
        
        while (!q.isEmpty()) {
            int turn = q.poll();
            if (count == m) {
                arr.add(turn);
                count = 0;
            } else
                q.add(turn);
            count++;
        }
        
        System.out.print("<");
        for (int j = 0; j < n; j++) {
            System.out.print(arr.get(j));
            if (j != n - 1)
                System.out.print(", ");
        }
        System.out.println(">");
    }
}