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
    
    // bottom-up
    // public static void solution() {
    //     int[] dp = new int[n + 2];

    //     for (int i = 1; i <= n; i++) { // i : 해당 일에 일을 했다면
    //         for (int j = i + date[i].day; j <= n + 1; j++) { // 다음에 할 수 있는 일을 순회
    //             if (dp[j] < dp[i] + date[i].price)
    //                 dp[j] = dp[i] + date[i].price;
    //             System.out.println();
    //             System.out.println(i + "일차에 일을 하기로 선택했다");
    //             System.out.println(j + "일을 선택할 수 있고");
    //             System.out.println(dp[j] + "원을 벌고 시작한다\n");
    //         }
    //     }
    //     System.out.println(dp[n + 1]);
    // }

    // top-down
    public static void solution() {
        int[] dp = new int[n + 2];


        for (int i = n; i > 0; i--) {
            if(i + date[i].day > n + 1)
                dp[i] = dp[i + 1];
            else
                dp[i] = Math.max(dp[i + 1], date[i].price + dp[i + date[i].day]);
        }
        System.out.println(dp[1]);
    }
}