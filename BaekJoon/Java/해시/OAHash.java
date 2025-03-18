public class OAHash {
    /*
     * Load factor = 원소의 개수 / 테이블의 크기
     *  - Chaining : 공간의 효율성을 생각하여 1이하가 되도록 만든다. (테이블의 크기를 원소의 개수보다 작게 한다.)
     *  - Open Address : 반드시 한 공간에 원소가 들어가야하기 때문에 1이하로 만들지 않는다. (테이블의 크기를 원소의 개수보다 크게 한다.)
     */

    static final int M = 1000003;   // HashTableSize
    static final int len = 1000;    // 3자릿수 문자열이 키 일때;

    static final int EMPTY = -1;
    static final int OCCUPY = 0;
    static final int DUMMY = 1;

    static int[] status = new int[M]; // EMPTY / OCCUPY / DUMMY
    static String[] key = new String[M];
    static int[] val = new int[M];

    public static void main(String[] args) {
                
    }

    public int find(String k) {
        int idx = stringHashFunction(k);
        while(status[idx] != EMPTY) {
            if (status[idx] == OCCUPY && key[idx] == k)
                return idx;
            idx = (idx + 1) % M;
        }
        return -1;
    }

    public void insert(String k, int v) {
        int idx = find(k);
        if (idx != -1) {
            val[idx] = v;
            return ;
        }
        idx = stringHashFunction(k);
        while (status[idx] == OCCUPY)
            idx = (idx + 1) % M;
        key[idx] = k;
        val[idx] = v;
        status[idx] = OCCUPY;
    }

    public void erase(String k) {
        int idx = find(k);
        if (idx != -1)
            status[idx] = DUMMY;
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