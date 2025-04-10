import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        int dna = Integer.parseInt(in[0]);
        int len = Integer.parseInt(in[1]);

        String str = br.readLine();
        in = br.readLine().split(" ");
        int[] ACGT = new int[4];
        for (int i = 0; i < 4; i++) {
            ACGT[i] = Integer.parseInt(in[i]);
        }

        Map<Character, Integer> dict = new HashMap<>();
        dict.put('A', 0);
        dict.put('C', 0);
        dict.put('T', 0);
        dict.put('G', 0);
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            Integer value = dict.get(ch);
            if (value != null)
                dict.put(ch, value + 1);
        }

        int s = 0;
        int e = len - 1;
        int count = 0;
        while (true) {
            if (checkPW(dict, ACGT) == true)
                count++;
            char excludeKey = str.charAt(s);
            dict.put(excludeKey, dict.get(excludeKey) - 1);
            s++;

            e++;
            if (e == dna)
                break;
            char includeKey = str.charAt(e);
            dict.put(includeKey, dict.get(includeKey) + 1);
        }
        System.out.println(count);
        br.close();
    }

    public static boolean checkPW(Map<Character, Integer> dict, int[] ACGT) {
        if (dict.get('A') >= ACGT[0] && dict.get('C') >= ACGT[1]
            && dict.get('G') >= ACGT[2] && dict.get('T') >= ACGT[3])
            return true;
        return false;

    }
}