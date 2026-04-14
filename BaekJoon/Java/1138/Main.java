import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num + 1];

        String[] in = br.readLine().split(" ");
        for (int i = 1; i <= num; i++) {
            arr[i] = Integer.parseInt(in[i - 1]);
        }

        soultion(arr, num);
        System.out.print(sb);
        br.close();
    }

    public static void soultion(int[] arr, int num) {
        List<Integer> lst = new LinkedList<>();
        lst.add(num); // 가장 키가 큰 사람을 넣고 시작
        for (int i = num - 1; i > 0; i--) {
            ListIterator<Integer> it = lst.listIterator();
            int step = 0;
            while (step < arr[i]) {
                it.next();
                step++;
            }
            it.add(i);
        }
        for (Integer integer : lst) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }
}