public class CHash {
    /*
     * Load factor = 원소의 개수 / 테이블의 크기
     *  - Chaining : 공간의 효율성을 생각하여 1이하가 되도록 만든다. (테이블의 크기를 원소의 개수보다 작게 한다.)
     *  - Open Address : 반드시 한 공간에 원소가 들어가야하기 때문에 1이하로 만들지 않는다. (테이블의 크기를 원소의 개수보다 크게 한다.)
     */

    static final int M = 1000003;   // HashTableSize
    static final int len = 1000;    // 3자릿수 문자열이 키 일때;
    static final int MAX = 500005;  // 최대 삽입 횟수

    static int[] head = new int[M];
    static int[] prev = new int[MAX];
    static int[] next = new int[MAX];

    static String[] key = new String[MAX];
    static int[] val = new int[MAX];
    static int unused = 0;
    public static void main(String[] args) {

    }

    public int find(String k) {
        int h = stringHashFunction(k);
        int idx = head[h];
        while (idx != -1) {
            if (key[idx] == k)
                return idx;
            idx = next[idx];
        }
    }

    public void insert(String k, int v) {
        int idx = find(k);
        if (idx != -1) {
            val[idx] = v;
            return ;
        }
        int h = stringHashFunction(k);
        key[unused] = k;
        val[unused] = v;
        if (head[h] != -1) {
            next[unused] = head[h];
            prev[head[h]] = unused;
        }
        head[h] = unused;
        unused++;
    }

    public void erase(String k) {
        int idx = find(k);
        if (idx == -1)
            return ;
        if (prev[idx] != -1)
            next[prev[idx]] = next[idx];
        if (next[idx] != -1)
            prev[next[idx]] = prev[idx];
        int h = stringHashFunction(k);
        if (head[h] == idx)
            head[h] = next[idx];
    }

    public static int integerHashFunction(int x) {
        return (M + x % M) % M;
    }

    public static int stringHashFunction(String string) {
        int h = 0;
        for (char x : string.toCharArray()) {
            h = (h * len + x) % M;
        }
        return h;
    }
}