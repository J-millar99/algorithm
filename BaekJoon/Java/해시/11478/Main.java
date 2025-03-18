import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String string = br.readLine();
        Set<String> set = new HashSet<>();
        int size = 1;
        int len = string.length();
        while (size <= len) {
            for (int i = 0; i + size <= len ; i++) {
                String str = string.substring(i, i + size);
                set.add(str);
            }
            size++;
        }
        System.out.println(set.size());
        br.close();
    }
}