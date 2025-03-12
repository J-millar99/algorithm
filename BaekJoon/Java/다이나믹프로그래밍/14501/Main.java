import java.io.*;
import java.util.ArrayList;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n;
    static Date[] date;
    static class Date {
        int day, price;
        Date(int day, int price) {
            this.day = day;
            this.price = price;
        }
    }
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Date[] date = new Date[n + 1];
        for (int i = 0; i < n; i++) {
            String[] in = br.readLine().split(" ");
            date[i + 1].day = Integer.parseInt(in[0]);
            date[i + 1].price = Integer.parseInt(in[1]);
        }

        solution(1, n);
        arr = new ArrayList<>();
        System.out.print(sb);
        br.close();
    }
    
    public static void solution(int start, int day) {
        for (int i = start; i <= n; i++) {

        }
    }
}