import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int ABSENT = 0;
    static final int ATTEND = 1;
    public static void main(String[] args) throws IOException {
        String in[] = br.readLine().split(" ");
        String S = in[0];
        String E = in[1];
        String Q = in[2];
        
        Map<String, Integer> field = new HashMap<>();
        int count = 0;
        while (true) {
            String line = br.readLine();
            if (line == null)
                break;
            in = line.split(" ");
            String time = in[0];
            String name = in[1];

            if (S.compareTo(time) >= 0) {
                field.put(name, ATTEND);
            }
            if ((E.compareTo(time) <= 0 && Q.compareTo(time) >= 0)) {
                if (field.containsKey(name) && field.get(name) == ATTEND) {
                    count++;
                    field.put(name, ABSENT);
                }
            }

        }
        System.out.println(count);
        br.close();
    }
}