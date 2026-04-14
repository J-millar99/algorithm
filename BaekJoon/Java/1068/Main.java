import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int delNode;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int root = 0;
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++)
            arr.add(new ArrayList<>());
        
        String[] in = br.readLine().split(" ");
        delNode = Integer.parseInt(br.readLine());
    
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(in[i]);
            if (num == -1) {
                root = i;
                continue;
            }
            arr.get(num).add(i);
        }

        if (delNode == root)
            answer = 0;
        else
            dfs(arr, root);
        System.out.println(answer);
        br.close();
    }

    public static void dfs(List<List<Integer>> arr, int root) {
        if (root == delNode)
            return;       
        List<Integer> childList = arr.get(root);
        if (childList.size() == 0) { // 리프 노드 판정
            answer++;
            return;
        }
        for (Integer child : childList) {
            if (child == delNode) {
                if (childList.size() == 1)
                    answer++;
                continue;
            }
            dfs(arr, child);
        }
    }
}