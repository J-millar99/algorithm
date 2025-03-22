import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int tries = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < tries; i++) {
            TreeMap<Integer, Integer> tree = new TreeMap<>();
            int num = Integer.parseInt(br.readLine());
            for (int j = 0; j < num; j++) {   
                String[] in = br.readLine().split(" ");
                String cmd = in[0];
                int val = Integer.parseInt(in[1]);
                if (cmd.equals("I"))
                    tree.put(val, tree.getOrDefault(val, 0) + 1);
                else if (cmd.equals("D") && !tree.isEmpty()) {
                    if (val == -1) { // 최솟값 제거
                        Map.Entry<Integer, Integer> e = tree.firstEntry();
                        if (e.getValue() == 1)
                            tree.remove(e.getKey());
                        else
                            tree.put(e.getKey(), e.getValue() - 1);
                    }
                    else if (val == 1) { // 최댓값 제거
                        Map.Entry<Integer, Integer> e = tree.lastEntry();
                        if (e.getValue() == 1)
                            tree.remove(e.getKey());
                        else
                            tree.put(e.getKey(), e.getValue() - 1);
                    }
                }
            }
            if (tree.isEmpty())
                sb.append("EMPTY");
            else {
                sb.append(tree.lastKey() + " " + tree.firstKey());
            }
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}