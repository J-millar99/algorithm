import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Merge {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr;
    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());
        arr = new int[size];

        String[] in = br.readLine().split(" ");
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(in[i]);
        }

        mergeSort(0, size);
        br.close();
    }

    public static void mergeSort(int s, int e) {
        if (s + 1 == e)
            return ;
        int mid = (s + e) / 2;
        // 나뉘는 범위 출력
        System.out.println("s: " + s + " | " + "e: " + e + " | " + "mid: " + mid);
        mergeSort(s, mid);
        mergeSort(mid, e);
        merge(s, e);
    }


    public static void merge(int s, int e) {
        int mid = (s + e) / 2;
        // 나뉘는 범위 출력
        // System.out.println("s: " + s + " | " + "e: " + e + " | " + "mid: " + mid);
        int arr1_idx = 0, arr2_idx = 0;
        
        int arr1_size = mid - s;
        int arr2_size = e - mid;
        int[] arr1 = new int[arr1_size];
        // 좌측 배열 복사
        for (int i = 0; i < arr1_size; i++)  arr1[i] = arr[s + i];

        // 좌측 배열이 잘 만들어졌는지 확인
        System.out.println("좌측 배열");
        for (int i : arr1)  System.out.print(i + " ");
        System.out.println();

        // 우측 배열 복사
        int[] arr2 = new int[arr2_size];
        for (int i = 0; i < arr2_size; i++)  arr2[i] = arr[mid + i];
        // 우측 배열이 잘 만들어졌는지 확인
        System.out.println("우측 배열");
        for (int i : arr2) System.out.print(i + " ");
        System.out.println();

        // 배열 합치기
        for (int i = s; i < s + arr1_size + arr2_size; i++) {
            if (arr1_idx == arr1_size)
                arr[i] = arr2[arr2_idx++];
            else if (arr2_idx == arr2_size)
                arr[i] = arr1[arr1_idx++];
            else if (arr1[arr1_idx] > arr2[arr2_idx])
                arr[i] = arr2[arr2_idx++];
            else
                arr[i] = arr1[arr1_idx++];
        }

        // 정렬 결과 출력
        System.out.println("정렬 결과");
        for (int i = s; i < s + arr1_size + arr2_size; i++) System.out.print(arr[i] + " ");
        System.out.println();
    }
}
