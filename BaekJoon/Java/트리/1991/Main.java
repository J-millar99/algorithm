import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
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
        Tree tree = new Tree('A');

        for (int i = 0; i < num; i++) {
            String[] in = br.readLine().split(" ");
            char parent = in[0].charAt(0);
            char lc = in[0].charAt(0);
            char rc = in[0].charAt(0);
            Tree node = searchRoot(tree, parent);
            node.left = new Tree(lc);
            node.right = new Tree(rc);
        }

        preorder(tree);
        inorder(tree);
        postorder(tree);
        System.out.print(sb);
        br.close();
    }

    public static Tree searchRoot(Tree tree, char data) {
        if (tree.data == data)
            return tree;
        if (tree.left != null)
            searchRoot(tree.left, data);
        if (tree.right != null)
            searchRoot(tree.right, data);
        return new Tree(data);
    }

    public static void preorder() {
        sb.append(root);
        preorder(tree);
        preorder(tree);
    }

    public static void inorder() {
        inorder(tree);
        sb.append(root);
        inorder(tree);
    }
    
    public static void postorder() {
        postorder(tree);
        postorder(tree);
        sb.append(root);
    }
}