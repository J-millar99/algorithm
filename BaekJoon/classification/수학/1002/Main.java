import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int tries = Integer.parseInt(br.readLine());

        for (int i = 0; i < tries; i++) {
            inputCordinates();
        }
        br.close();
    }
    public static void inputCordinates() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken()), y1 = Integer.parseInt(st.nextToken()); // 조규현의 좌표
        int r1 = Integer.parseInt(st.nextToken()); // 조 - 류 거리

        int x2 = Integer.parseInt(st.nextToken()), y2 = Integer.parseInt(st.nextToken()); // 백승환의 좌표
        int r2 = Integer.parseInt(st.nextToken()); // 백 - 류 거리

        double d = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        if (r1 + r2 < d) // 원이 만나지 않는다.
            System.out.println("0");
        else if (r1 == r2 && d == 0) // 원이 겹친다.
            System.out.println("-1");
        else if (r1 + r2 == d) // 원이 외접한다.
            System.out.println("1");
        else if (d + Math.min(r1, r2) == Math.max(r1, r2)) // 원이 내접한다.
            System.out.println("1");
        else if (d + Math.min(r1, r2) < Math.max(r1, r2)) // 원이 안에서 만나지 않는다.
            System.out.println("0");
        else
            System.out.println("2");
    }
}
