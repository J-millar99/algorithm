import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        int[] arr = new int[input.length];

        for (int i = 0; i < m; i++)
            arr[i] = Integer.parseInt(input[i]);
        
        br.close();
    }

    public static int rotateRight() {
        int count = 0;
        return count;
    }

    public static int rotateLeft() {
        int count = 0;
        return count;
    }
}