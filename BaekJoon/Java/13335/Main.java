import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]); // 트럭의 대수
        int w = Integer.parseInt(in[1]); // 다리길이
        int l = Integer.parseInt(in[2]); // 하중

        int[] trucks = new int[n + 1]; // 1번 인덱스부터 사용
        in = br.readLine().split(" "); 
        for (int i = 1; i <= n; i++)
            trucks[i] = Integer.parseInt(in[i - 1]);
        solution(n, w, l, trucks);
        br.close();
    }

    public static void solution(int n, int w, int l, int[] trucks) {
        int[] bridge = new int[w];
        int next = 1;
        int time = 0;
        while (true) {
            moveForward(bridge); // 한 칸씩 이동
            ++time;
            int weight = calWeightOnBridge(bridge);
            if (next != n + 1 // 모든 트럭이 올랐는지 확인
                && weight + trucks[next] <= l) { // 트럭을 한 대 더 싣기
                bridge[0] = trucks[next++];
            } else // 실을 수 없다면 첫 번째 자리가 0
                bridge[0] = 0;
            if (escapeCondition(bridge)) // 종료조건 : 트럭이 모두 지나감
                break;
        }
        System.out.println(time);
    }

    public static void print(int[] bridge) {
        for (int i = 0; i < bridge.length; i++) {
            System.out.print(bridge[i] + " ");
        }
        System.out.println();
    }

    public static boolean escapeCondition(int[] bridge) {
        int sum = 0;
        for (int i = 0; i < bridge.length; i++) {
            sum += bridge[i];
        }
        if (sum == 0)
            return true;
        return false;
    }

    public static void moveForward(int[] bridge) {
        for (int i = bridge.length - 1; i > 0; i--) {
            bridge[i] = bridge[i - 1];
        }
        bridge[0] = 0;
    }

    public static int calWeightOnBridge(int[] bridge) {
        int weight = 0;
        for (int i = 0; i < bridge.length; i++) {
            weight += bridge[i];
        }
        return weight;
    }
}