import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        String in = br.readLine();

        int[] arr = new int[in.length()];
        for (int i = 0; i < in.length(); i++) {
            arr[i] = in.charAt(i) - '0';
        }
        Arrays.sort(arr);
        for (int i = in.length() - 1; i > -1; i--) {
            sb.append(arr[i]);
        }
        System.out.println(sb);
        br.close();
    }
}