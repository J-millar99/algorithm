import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int tries = Integer.parseInt(br.readLine());
        for (int i = 0; i < tries; i++) {
            // 수행 명령어 입력
            String cmd = br.readLine();

            // 배열 크기
            int size = Integer.parseInt(br.readLine());

            // 배열 파싱
            String str = br.readLine();
            str = str.substring(1, str.length() - 1);
            String[] arr = str.split(",");

            // 자료구조 삽입
            ArrayDeque<Integer> dq = new ArrayDeque<>();
            for (int j = 0; j < size; j++)
                dq.add(Integer.parseInt(arr[j]));
            
            int rotate = 0;
            boolean flag = false;
            for (char c : cmd.toCharArray()) {
                if (c == 'R')
                    rotate++;
                else if (c == 'D') {
                    if (dq.isEmpty()) {
                        flag = true;
                        break;
                    }
                    if (rotate % 2 == 0) // 짝수면
                        dq.pollFirst();
                    else if (rotate % 2 == 1) // 홀수면
                        dq.pollLast();
                }
            }
            if (flag == true)
                sb.append("error\n");
            else {
                sb.append("[");
                int reSize = dq.size();
                if (rotate % 2 == 1) {
                    for (int j = 0; j < reSize; j++) {
                        sb.append(dq.pollLast());
                        if (j != reSize - 1)
                            sb.append(",");
                    }
                } else {
                    for (int j = 0; j < reSize; j++) {
                        sb.append(dq.pollFirst());
                        if (j != reSize - 1)
                            sb.append(",");
                    }
                }
                sb.append("]\n");
            }
        }
        System.out.print(sb);
        br.close();
    }
}