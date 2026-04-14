import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            count += checkGroupWord(str);
        }
        System.out.println(count);
        br.close();
    }
    public static int checkGroupWord(String str) {
        boolean[] b = new boolean[26];
        char prev = str.charAt(0);
        b[prev - 'a'] = true;
        for (char ch : str.toCharArray()) {
            if (prev == ch)
                continue;
            if (b[ch - 'a'] == true)
                return 0;
            b[ch - 'a'] = true;
            prev = ch;
        }
        return 1;
    }
}
