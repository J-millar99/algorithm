import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Double> subjectScoreMap = new HashMap<>();

        subjectScoreMap.put("A+", 4.5);
        subjectScoreMap.put("A0", 4.0);
        subjectScoreMap.put("B+", 3.5);
        subjectScoreMap.put("B0", 3.0);
        subjectScoreMap.put("C+", 2.5);
        subjectScoreMap.put("C0", 2.0);
        subjectScoreMap.put("D+", 1.5);
        subjectScoreMap.put("D0", 1.0);
        subjectScoreMap.put("F", 0.0);

        double ret = 0;
        double div = 0;
        for (int i = 0; i < 20; i++) {
            String input[] = br.readLine().split(" ");
            if (input[2].equals("P"))
                continue;
            double score = Double.parseDouble(input[1]);
            div += score;
            ret += score * subjectScoreMap.get(input[2]);
        }

        System.out.println(ret / div);
        br.close();
    }
}
