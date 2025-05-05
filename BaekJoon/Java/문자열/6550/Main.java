import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String input;
        while ((input = br.readLine()) != null) {
            String[] in = input.split(" ");

            String src = in[0];
            int srcLen = src.length();
            String dest = in[1];
            int destLen = dest.length();

            int i, j;
            i = j = 0;

            while (true) {
                char srcChar = src.charAt(i);
                char destChar = dest.charAt(j);
                if (srcChar == destChar)
                    i++;
                j++;
                if (i == srcLen || j == destLen)
                    break;
            }
            if (i != srcLen && j == destLen)
                System.out.println("No");
            else
                System.out.println("Yes");
        }
    }
}