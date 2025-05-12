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
        int right = n - 1;
        int minSum = Math.abs(arr[left] + arr[right]);
        int ret1 = left;
        int ret2 = right;
        while (left < right) {
            int min = arr[left] + arr[right];
            if (Math.abs(min) < minSum) {
                minSum = Math.abs(min);
                ret1 = left;
                ret2 = right;
                if (min == 0)
                    break;
            }

            if (min < 0) // 값이 음수이면 더 작은 음수를 만듦
                left++;
            else // 값이 양수면 더 작은 양수를 만듦
                right--;
        }
        System.out.println(arr[ret1] + " " + arr[ret2]);
    }
}