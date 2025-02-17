import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        ArrayList<Integer> arr = new ArrayList<>();
        
        for (int i = 0; i < n; i++)
            arr.add(Integer.parseInt(str[i]));
        Collections.sort(arr);

        int sum = 0;
        for (int j = 0; j < n; j++)
            sum += arr.get(j) * (n - j);
        System.out.println(sum);
        br.close();
    }
}
