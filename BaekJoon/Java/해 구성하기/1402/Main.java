import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tries = Integer.parseInt(br.readLine());

        for (int i = 0; i < tries; i++) {
            br.readLine();
            System.out.println("yes");
            
            // int a, b;
            // String[] input = br.readLine().split(" ");
            // a = Integer.parseInt(input[0]);
            // b = Integer.parseInt(input[1]);
            // solution(a, b);
        }
        br.close();
    }

    // public static void solution(int a, int b) {
    //     if (a < b)
    //         System.out.println("yes");
    //     else if (a == b && (a == 0 || a == 2))
    //         System.out.println("yes");
    //     else if (a == b)
    //         System.out.println("no");
    //     else { // a > b
    //         int primeSum = 0;
    //         int div = 2;
    //         while (a != 1) {
    //             if (a % div == 0) {
    //                 a /= div;
    //                 primeSum += div;
    //             } else
    //                 ++div;
    //         }
    //         if (primeSum <= b)
    //             System.out.println("yes");
    //         else
    //             System.out.println("no");
    //     }
    // }
}