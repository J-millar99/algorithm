import java.io.*;

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
        n = Integer.parseInt(br.readLine());
        date = new Date[n + 1];
        for (int i = 1; i <= n; i++) {
            String[] in = br.readLine().split(" ");
            int day = Integer.parseInt(in[0]);
            int price = Integer.parseInt(in[1]);
            date[i] = new Date(day, price);
        }
        solution();
        System.out.print(sb);
        br.close();
    }
    
    public static void solution() {
        int[] dp = new int[n + 1];
        int leave = n;

        for (int i = 1; i <= n; i++) {
            int cost = leave - date[i].day;
            if (cost >= 0)
                System.out.println("cost: " + cost);
            leave--;
        }
    }
}