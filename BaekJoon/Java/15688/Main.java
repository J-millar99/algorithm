import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numbers = Integer.parseInt(br.readLine());
        
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < numbers; i++)
            arr.add(Integer.parseInt(br.readLine()));
        arr.sort(null);
        StringBuilder sb = new StringBuilder();
        for (int num : arr)
            sb.append(num).append("\n");
        System.out.print(sb);
        br.close();
    }
}
