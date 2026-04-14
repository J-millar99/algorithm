public class Main {
    public static void main(String[] args) {
        boolean[] b = new boolean[10003];
        for (int i = 1; i < 9973; i++) {
            int off = checkSelfNumber(i);
            b[off] = true;
        }
        for (int j = 1; j <= 10000; j++)
            if (b[j] == false)
                System.out.println(j);
    }

    public static int checkSelfNumber(int i) {
        int ret = i;
        ret += i / 1000; i %= 1000;
        ret += i / 100; i %= 100;
        ret += i / 10;
        ret += i % 10;
        return ret;
    }
}