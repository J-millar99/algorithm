import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        int size1 = Integer.parseInt(in[0]);
        int size2 = Integer.parseInt(in[1]);

        in = br.readLine().split(" ");
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            arr.add(Integer.parseInt(in[i]));
        }
        arr.sort(null);

        in = br.readLine().split(" ");
        int[] finds = new int[size2];
        for (int i = 0; i < size2; i++) {
            finds[i] = Integer.parseInt(in[i]);
        }

        List<Integer> remov = new ArrayList<>();
        for (int i = 0; i < size2; i++) {
            int idx = binarySearch(finds[i], arr);
            if (idx != -1)
                remov.add(finds[i]);
        }
        remov.sort(null);
        
        if (remov.size() == arr.size())
            System.out.println("0");
        else {
            int seq = 0;
            for (int i = 0; i < size1; i++) {
                int num = arr.get(i);
                if (seq < remov.size() && num == remov.get(seq))
                    seq++;
                else
                    sb.append(num).append(" ");
            }
            System.out.println(size1 - seq);
            System.out.println(sb);
        }
        br.close();
    }

    public static int binarySearch(int find, List<Integer> arr) {
        int s = 0;
        int e = arr.size() - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            int target = arr.get(mid);
            if (find == target)
                return mid;
            else if (find < target)
                e = mid - 1;
            else
                s = mid + 1;
        }
        return -1;
    }
}