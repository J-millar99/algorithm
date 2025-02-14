import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numbers = Integer.parseInt(br.readLine());
        
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < numbers; i++)
            al.add(Integer.parseInt(br.readLine()));
        Collections.sort(al);
        StringBuilder sb = new StringBuilder();
        for (int num : al)
            sb.append(num).append("\n");
        System.out.print(sb);
        br.close();
    }
}
