import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = br.readLine();

        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < in.length(); i++) {
            arr.add(in.substring(i));
        }
        arr.sort(null);

        StringBuilder sb = new StringBuilder();
        for (String string : arr) {
            sb.append(string).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}