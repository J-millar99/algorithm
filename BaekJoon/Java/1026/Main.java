import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        String[] input = br.readLine().split(" ");
        for (String string : input)
            a.add(Integer.parseInt(string));
        
        input = br.readLine().split(" ");
        for (String string : input)
            b.add(Integer.parseInt(string));
        
        a.sort(null);
        b.sort(Comparator.reverseOrder());

        int sum = 0;
        for (int i = 0; i < num; i++) {
            sum += a.get(i) * b.get(i);
        }
        System.out.println(sum);
        br.close();
    }    
}
