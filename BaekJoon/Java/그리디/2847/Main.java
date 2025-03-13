import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] level = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            level[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for (int i = n; i > 1; i--) {
            int pivot = level[i];
            if (pivot <= level[i - 1]) {
                int cal = level[i - 1] - pivot + 1;
                count += cal;
                level[i - 1] -= cal; 
            }
        }

        System.out.println(count);
        br.close();
    }
}
