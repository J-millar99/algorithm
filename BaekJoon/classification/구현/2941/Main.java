import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static ArrayList<String> dic = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int count = 0;
        makeDictionary();

        for (String sep : dic) {
            int idx = input.indexOf(sep);
            while (idx != -1) {
                count++;
                input = input.substring(0, idx) + " " + input.substring(idx + sep.length());
                idx = input.indexOf(sep);
            }
        }
        input = input.replace(" ", "");
        count += input.length();
        System.out.println(count);
        br.close();
    }

    public static void makeDictionary() {
        dic.add("c=");
        dic.add("c-");
        dic.add("dz=");
        dic.add("d-");
        dic.add("lj");
        dic.add("nj");
        dic.add("s=");
        dic.add("z=");
    }
}
