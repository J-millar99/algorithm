import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        int num = Integer.parseInt(in[0]);
        int turn = Integer.parseInt(in[1]);
        System.out.println(solution(num, turn));
        br.close();
    }

    public static int solution(int num, int turn) {
        int count = 0;
        boolean[] arr = new boolean[num + 1];
        int mul = 2;
        while(true) {
            int i = 1;
            while(mul * i <= num) {
                if (arr[mul * i] == false) {
                    arr[mul * i] = true;
                    count++;
                    if (count == turn)
                        return mul * i;
                }
                i++;
            }
            mul++;
        }
    }
}