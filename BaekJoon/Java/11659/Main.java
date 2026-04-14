import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); int m = Integer.parseInt(st.nextToken());
        String[] strs = br.readLine().split(" ");
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0); // 0번 인덱스를 0으로 둠
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(strs[i]);
            arr.add(num + arr.get(i));
        }

        for (int j = 0; j < m; j++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); int e = Integer.parseInt(st.nextToken());
            System.out.println(arr.get(e) - arr.get(s - 1));
        }
        br.close();
    }
}
