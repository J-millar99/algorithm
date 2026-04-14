import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arr;
    static boolean[] visited, finished, isTeam;
    static int cycleStart = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int tries = Integer.parseInt(br.readLine());
        for (int i = 0; i < tries; i++) {
            int num = Integer.parseInt(br.readLine());
            arr = new int[num + 1];
            String[] in = br.readLine().split(" ");

            for (int j = 1; j <= num; j++) 
                arr[j] = Integer.parseInt(in[j - 1]);
            
            visited = new boolean[num + 1];
            finished = new boolean[num + 1];
            isTeam = new boolean[num + 1];

            for (int j = 1; j <= num; j++) {
                if (!finished[j]) {
                    cycleStart = -1;
                    teammate(j);
                }
            }
            int count = 0;
            for (int j = 1; j <= num; j++) {
                if (!isTeam[j])
                    count++;
            }
            sb.append(count).append("\n");
        }
        br.close();
        System.out.print(sb);
    }

    public static void teammate(int node) {
        visited[node] = true;
        int next = arr[node];

        if (!visited[next]) // 방문 안한 노드
            teammate(next); // 재귀 진행
        else if (!finished[next])
            cycleStart = next;

        finished[node] = true;

        if (cycleStart != -1) {
            isTeam[node] = true;
            if (node == cycleStart)
                cycleStart = -1;
        }
    }
}
