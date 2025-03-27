public class PriorityQueue {
    static int[] heap = new int[1000005];
    static int size = 0;
    static final int MAX = Integer.MAX_VALUE;
    public static void main(String[] args) {
        for (int i = 0; i < heap.length; i++) {
            heap[i] = MAX;
        }
    }

    public static void push(int x){
        heap[size++] = x;
        int idx = size;
        while(idx != 1) {
            int par = idx / 2; // 부모 기준으로
            if (heap[par] <= heap[idx]) // 방금 삽입한 노드가 더 크다면 중지
                break;
            int temp = heap[idx]; // 아니라면 스왑
            heap[idx] = heap[par];
            heap[par] = heap[temp];
            idx = par;
        }
    }

    public int top() {
        return heap[1];
    }

    public void pop() {
        heap[1] = heap[size--];
        int idx = 1;
        while (2 * idx <= size) {
            int left = 2 * idx;
            int right = 2 * idx + 1;
            int minIndex = left;
            if (right <= size && heap[right] < heap[left]) // 오른쪽 자식까지 존재할 때 오른쪽이 작으면
                minIndex = right;
            if (heap[idx] <= heap[minIndex]) // 작은 노드가 부모랑 비교했을때, 부모가 더 작다면 중지
                break;
            int temp = heap[idx];
            heap[idx] = heap[minIndex];
            heap[minIndex] = heap[temp];
            idx = minIndex;
        }
    }
}
