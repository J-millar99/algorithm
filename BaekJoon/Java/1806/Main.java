import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int target = Integer.parseInt(in[1]);

        in = br.readLine().split(" ");
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(in[i]);
            arr[i] = v;
            sum += v;
        }

        if (sum < target)
            System.out.println(0);
        else
            System.out.println(solution(n, arr, target));
        br.close();
    }

    public static int solution(int n, int[] arr, int target) {
        int len = Integer.MAX_VALUE;
        int sum = 0;
        int s, e;
        s = e = 0;

        while (s <= e) {
            if (sum >= target) {
                len = Math.min(len, e - s);
                sum -= arr[s++];
            } else {
                if (e == n)
                    break;
                sum += arr[e++];
            }
        }
        return len;
    }
}