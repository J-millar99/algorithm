import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        int row = Integer.parseInt(in[0]);
        int col = Integer.parseInt(in[1]);

        double area = 0;
        for (int i = 0; i < row; i++) {
            String line = br.readLine();
            boolean flag = false; // 넓이 확장중인 flag
            double subArea = 0;
            for (int j = 0; j < col; j++) {
                char ch = line.charAt(j);

                if (ch == '/' || ch == '\\') {
                    if (flag == false)
                        flag = true;
                    else if (flag == true)
                        flag = false;
                    subArea += 0.5;
                } else if (ch == '.' && flag == true) {
                    subArea += 1;
                }
            }
            area += subArea;
        }
        System.out.println((int)area);
        br.close();
    }
}