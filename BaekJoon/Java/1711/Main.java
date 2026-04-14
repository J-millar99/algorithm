import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        long[][] posArr = new long[num][2];
        for (int i = 0; i < num; i++) {
            String[] in = br.readLine().split(" ");
            posArr[i][0] = Long.parseLong(in[0]);
            posArr[i][1] = Long.parseLong(in[1]);
        }
        solution(posArr, num);
        br.close();
    }

    public static void solution(long[][] arr, int size) {
        int count = 0;
        for (int i = 0; i < size - 2; i++) {
            for (int j = i + 1; j < size - 1; j++) {
                for (int k = j + 1; k < size; k++) {
                    if (pythagoras(arr[i], arr[j], arr[k]))
                        ++count;
                }
            }
        }
        System.out.println(count);
    }

    public static boolean pythagoras(long[] p1, long[] p2, long[] p3) {
        long d1 = (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
        long d2 = (p1[0] - p3[0]) * (p1[0] - p3[0]) + (p1[1] - p3[1]) * (p1[1] - p3[1]);
        long d3 = (p2[0] - p3[0]) * (p2[0] - p3[0]) + (p2[1] - p3[1]) * (p2[1] - p3[1]);

        if (d1 + d2 == d3 || d1 + d3 == d2 || d2 + d3 == d1)
            return true;
        return false;
    }
}