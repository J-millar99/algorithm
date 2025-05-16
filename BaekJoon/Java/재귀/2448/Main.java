import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());

        starTree(size, 0);
        br.close();
    }

    public static void starTree(int size, int depth) {
        if (size == depth)
            return;
        top(size, depth);
        mid(size, depth);
        bot(size ,depth);
        starTree(size, depth + 1);
    }
    
    public static void top(int size, int depth) {
        sb.append("*\n");        
    }
    
    public static void mid(int size, int depth) {
        sb.append("* *\n");
    }

    public static void bot(int size, int depth) {
        sb.append("*****\n");
    }
}