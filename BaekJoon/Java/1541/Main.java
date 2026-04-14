import java.io.*;

public class Main {
    static boolean flag = false;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] lines = input.split("-");

        int sum = 0;
        for (String line : lines) {
            sum += plusNum(line);
            flag = true;
        }

        System.out.println(sum);
        br.close();
    }

    public static int plusNum(String exp) {
        int ret = 0;
        // 올바른 예: 리터럴 '+'를 찾기 위해 이스케이프 처리
        String[] lines = exp.split("\\+");

        for (String line : lines)
            ret += Integer.parseInt(line);
        if (flag == false)
            return ret;
        return ret * -1;
    }
}