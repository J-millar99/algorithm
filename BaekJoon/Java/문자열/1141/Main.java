import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            arr.add(str);
        }

        arr.sort(Comparator.comparing(String::length));
        boolean[] visit = new boolean[n];

        for (int i = 0; i < n - 1; i++) {
            String str1 = arr.get(i);
            for (int j = i + 1; j < n; j++) {
                String str2 = arr.get(j);
                if (str2.startsWith(str1)) {
                    visit[i] = true;
                    break;
                }
            }
        }
        br.close();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (visit[i] == false)
                answer++;
        }
        System.out.println(answer);
    }
}