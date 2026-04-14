import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 스위치의 수
        int n = Integer.parseInt(br.readLine());
        int[] sbyte = new int[n + 1];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            if (input[i].equals("1"))
                ++sbyte[i + 1];

        // 학생 수
        int m = Integer.parseInt(br.readLine());
        for (int j = 0; j < m; j++) {
            input = br.readLine().split(" "); 
            int gender = Integer.parseInt(input[0]);
            int receive = Integer.parseInt(input[1]);
            int idx = receive;
            int i = 1;
            if (gender == 1) {
                int mul = idx * i;
                while (mul <= n) {
                    sbyte[mul] ^= 1;
                    i++;
                    mul = idx * i;
                }
            } else {
                sbyte[idx] ^= 1; // 자기 자신 대칭
                while (true) {
                    if (!(idx - i >= 1 && idx + i <= n)) // 범위 초과하여 대칭할 수 없는 경우
                        break;
                    if (sbyte[idx - i] == sbyte[idx + i]) { // 값이 같아 대칭인 경우
                        sbyte[idx - i] ^= 1; sbyte[idx + i] ^= 1;
                    } else
                        break;
                    ++i;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(sbyte[i]);
            if (i % 20 == 0)
                sb.append("\n");
            else
                sb.append(" ");
        }
        if (n % 20 == 0)
            System.out.print(sb);
        else
            System.out.println(sb);
    
        br.close();
    }
}