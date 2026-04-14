import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numbers = Integer.parseInt(br.readLine());
        
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < numbers; i++)
            arr.add(Integer.parseInt(br.readLine()));
        arr.sort(Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (int num : arr)
            sb.append(num).append("\n");
        System.out.print(sb);
        br.close();
    }
}
