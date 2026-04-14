import java.io.*;
import java.util.PriorityQueue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine()); // 카드 묶음 개수
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 큰 수는 연산에 적게 참여해야하므로 우선순위 큐 사용
        int count = 0; // 비교 횟수

        // pq에 요소를 입력
        for (int i = 0; i < n; i++) 
            pq.add(Integer.parseInt(br.readLine()));
        
        System.out.println(pq.size());
        // 최후의 1개의 카드묶음이 탄생할 때까지 반복
        while (pq.size() > 1) {
            int sum = pq.poll() + pq.poll();
            count += sum;
            pq.add(sum);
        }

        // ※ 카드 묶음이 한 개면 비교횟수는 0
        System.out.println(count);
    }
}
