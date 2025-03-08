import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        int arr1_size = Integer.parseInt(in[0]);
        int arr2_size = Integer.parseInt(in[1]);

        int[] arr1 = new int[arr1_size];
        int[] arr2 = new int[arr2_size];

        in = br.readLine().split(" ");
        for (int i = 0; i < arr1_size; i++) {
            arr1[i] = Integer.parseInt(in[i]);
        }

        in = br.readLine().split(" ");
        for (int i = 0; i < arr2_size; i++) {
            arr2[i] = Integer.parseInt(in[i]);
        }

        int arr1_idx = 0, arr2_idx = 0;
        
        int[] arr = new int[arr1_size + arr2_size];
        for (int i = 0; i < arr1_size + arr2_size; i++) {
            if (arr1_idx == arr1_size)
                arr[i] = arr2[arr2_idx++];
            else if (arr2_idx == arr2_size)
                arr[i] = arr1[arr1_idx++];
            else if (arr1[arr1_idx] > arr2[arr2_idx])
                arr[i] = arr2[arr2_idx++];
            else
                arr[i] = arr1[arr1_idx++];
        }
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
        br.close();
    }
}