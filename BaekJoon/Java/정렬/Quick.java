import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Quick {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr;
    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());
        arr = new int[size];

        String[] in = br.readLine().split(" ");
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(in[i]);
        }

        quickSort(0, size);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        br.close();
    }

    public static void quickSort(int s, int e) {
        if (s + 1 >= e)
            return ;
        int pivot = arr[s];
        int lptr = s + 1;
        int rptr = e - 1;
        while(true) {
            while (lptr <= rptr && arr[lptr] <= pivot) lptr++;
            while (lptr <= rptr && arr[rptr] >= pivot) rptr--;
            if (lptr > rptr)
                break;
            swap(lptr, rptr);
        }
        swap(s, rptr);
        quickSort(s, rptr);
        quickSort(rptr + 1, e);
    }

    public static void swap(int idx1, int idx2) {
        int temp = arr[idx2];
        arr[idx2] = arr[idx1];
        arr[idx1] = temp;
    }
}
