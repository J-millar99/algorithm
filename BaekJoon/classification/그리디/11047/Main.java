import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();
        int i;
        for (i = 0; i < n; i++)
            list.add(Integer.parseInt(br.readLine()));
        
        int result = 0;
        for (i = n - 1; i > -1; i--) {
            result += (k / list.get(i));
            k %= list.get(i);
        }
        System.out.println(result);
    }    
}
