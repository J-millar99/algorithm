import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static class Tree {
        char data;
        Tree left;
        Tree right;
        public Tree(char data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static StringBuilder sb = new StringBuilder();
    static Tree node;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Tree rootNode = new Tree('A');
    
        for (int i = 0; i < n; i++) {
            String[] in = br.readLine().split(" ");
            char data, left, right;
            
            data = in[0].charAt(0);
            left = in[1].charAt(0);
            right = in[2].charAt(0);

            searchNode(rootNode, data);
            if (left != '.') {
                node.left = new Tree(left);
            }
            if (right != '.')
                node.right = new Tree(right);
        }

        preorder(rootNode);
        sb.append("\n");
        inorder(rootNode);
        sb.append("\n");
        postorder(rootNode);
        sb.append("\n");

        System.out.print(sb);
        br.close();
    }

    public static void searchNode(Tree head, char data) {
        if (data == head.data) {
            node = head;
            return ;
        }
        if (head.left != null)
            searchNode(head.left, data);
        if (head.right != null)
            searchNode(head.right, data);
    }

    public static void preorder(Tree rootNode) {
        if (rootNode == null)
            return;
        sb.append(rootNode.data);
        preorder(rootNode.left);
        preorder(rootNode.right);
    }

    public static void inorder(Tree rootNode) {
        if (rootNode == null)
            return;
        inorder(rootNode.left);
        sb.append(rootNode.data);
        inorder(rootNode.right);
    }

    public static void postorder(Tree rootNode) {
        if (rootNode == null)
            return;
        postorder(rootNode.left);
        postorder(rootNode.right);
        sb.append(rootNode.data);
    }
}