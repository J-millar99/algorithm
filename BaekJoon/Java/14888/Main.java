import java.io.*;
import java.util.*;

public class Main {
    static int[] numbers;
    static List<Character> operators;
    static List<Integer> arr = new ArrayList<>();
    static boolean[] visit;
    static char[] node;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        String[] in = br.readLine().split(" ");
        numbers = new int[n + 1];
        // numbers[] 인덱스 1부터 n까지 배정
        for (int i = 1; i <= n; i++) {
            numbers[i] = Integer.parseInt(in[i - 1]);
        }

        in = br.readLine().split(" ");
        operators = new ArrayList<>();
        // operators array는 인덱스 0부터 시작
        for (int i = 0; i < Integer.parseInt(in[0]); i++) {
            operators.add('+');
        }
        for (int i = 0; i < Integer.parseInt(in[1]); i++) {
            operators.add('-');
        }
        for (int i = 0; i < Integer.parseInt(in[2]); i++) {
            operators.add('*');
        }
        for (int i = 0; i < Integer.parseInt(in[3]); i++) {
            operators.add('/');
        }
    
        // 선택된 연산자 수 : n - 1개가 필요한데 인덱스를 1부터 가져가려면 +1
        node = new char[n];
        
        // 연산자의 visit 배열도 연산자의 개수만큼 필요하고 인덱스 1부터 시작하도록
        visit = new boolean[operators.size() + 1];
        backTracking(1);
        arr.sort(null);

        System.out.println(arr.get(arr.size() - 1));
        System.out.println(arr.get(0));
        br.close();
    }

    public static void backTracking(int start) {
        if (start == n) {
            int result = numbers[1];
            for (int i = 1; i < n; i++) {
                if (node[i] == '+')
                    result += numbers[i + 1];
                else if (node[i] == '-')
                    result -= numbers[i + 1];
                else if (node[i] == '*')
                    result *= numbers[i + 1];
                else if (node[i] == '/') {
                    if (result < 0) {
                        result *= -1;
                        result /= numbers[i + 1];
                        result *= -1;
                    } else
                        result /= numbers[i + 1];
                }
            }
            arr.add(result);
            return;
        }

        for (int i = 1; i < n; i++) {
            if (visit[i] == false) {
                node[start] = operators.get(i - 1);
                visit[i] = true;
                backTracking(start + 1);
                visit[i] = false;
            }
        }
    }
}
