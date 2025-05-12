import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] in = br.readLine().split(" ");
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(in[i]);
        
        solution(arr, n);
        br.close();
    }

    public static void solution(int[] arr, int n) {
        int left = 0;
        int right = 0;

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            int curr = arr[i];
            int s = i + 1;
            int e = n - 1;

            while (s <= e) {
                int mid = (s + e) / 2;
                int temp = curr + arr[mid];

                if (Math.abs(temp) < ans) {
                    ans = Math.abs(temp);
                    left = i;
                    right = mid;

                    if (temp == 0)
                        break;
                }

                if (temp < 0)
                    s = mid + 1;
                else
                    e = mid - 1;
            }
        }

        System.out.println(arr[left] + " " + arr[right]);
    }
}