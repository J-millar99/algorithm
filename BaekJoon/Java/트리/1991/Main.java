import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Tree node;
    static class Tree {
        char data;
        Tree left;
        Tree right;
        Tree (char data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    
    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());

        Tree head = createRootNode();
        for (int i = 0; i < num - 1; i++) {
            String[] in = br.readLine().split(" ");
            char parent = in[0].charAt(0);
            char lc = in[1].charAt(0);
            char rc = in[2].charAt(0);

            node = null;                // 탐색 노드를 널 포인터로 시작
            searchNode(head, parent);   // 찾았다면 해당 노드가 node의 참조가 되고 아니라면 널

            if (node == null)           // 찾지 못했다면 해당 노드를 생성
                node = new Tree(parent);
            if (lc != '.')
                node.left = new Tree(lc);
            if (rc != '.')
                node.right = new Tree(rc);
        }

        preorder(head);
        sb.append("\n");
        inorder(head);
        sb.append("\n");
        postorder(head);
        sb.append("\n");
        System.out.print(sb);
        br.close();
    }
    
    public static Tree createRootNode() throws IOException {
        String[] in = br.readLine().split(" ");
        char parent = in[0].charAt(0);
        char lc = in[1].charAt(0);
        char rc = in[2].charAt(0);
    
        Tree root = new Tree(parent);
        if (lc != '.')
            root.left = new Tree(lc);
        if (rc != '.')
            root.right = new Tree(rc);

        return root;
    }

    public static void searchNode(Tree head, char data) {
        if (head.data == data) {
            node = head;
            return;
        }
        if (head.left != null)
            searchNode(head.left, data);
        if (head.right != null)
            searchNode(head.right, data);
    }

    public static void preorder(Tree head) {
        if (head == null)
            return;
        sb.append(head.data);
        preorder(head.left);
        preorder(head.right);
    }

    public static void inorder(Tree head) {
        if (head == null)
            return;
        inorder(head.left);
        sb.append(head.data);
        inorder(head.right);
    }
    
    public static void postorder(Tree head) {
        if (head == null)
            return;
        postorder(head.left);
        postorder(head.right);
        sb.append(head.data);
    }
}