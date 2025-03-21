// 이진 검색 트리 구현
public class BinarySearchTree {
    
    // 트리의 노드를 나타내는 클래스
    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    
    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    // 삽입 메서드
    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        // 빈 노드에 새로운 노드 삽입
        if (root == null) {
            root = new Node(data);
            return root;
        }

        // 데이터를 기준으로 왼쪽 또는 오른쪽 서브트리에 삽입
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    // 검색 메서드
    public boolean search(int data) {
        return searchRec(root, data);
    }

    private boolean searchRec(Node root, int data) {
        // 트리가 비었으면 해당 데이터를 찾을 수 없음
        if (root == null) {
            return false;
        }

        // 데이터를 찾으면 true 반환
        if (data == root.data) {
            return true;
        }

        // 데이터를 기준으로 왼쪽 또는 오른쪽 서브트리 검색
        if (data < root.data) {
            return searchRec(root.left, data);
        } else {
            return searchRec(root.right, data);
        }
    }

    // 중위 순회 (Inorder Traversal)
    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);  // 왼쪽 서브트리
            System.out.print(root.data + " ");  // 현재 노드
            inorderRec(root.right);  // 오른쪽 서브트리
        }
    }

    // 삭제 메서드
    public void delete(int data) {
        root = deleteRec(root, data);
    }

    private Node deleteRec(Node root, int data) {
        if (root == null) {
            return root;
        }

        // 데이터를 기준으로 왼쪽 또는 오른쪽 서브트리로 내려가기
        if (data < root.data) {
            root.left = deleteRec(root.left, data);
        } else if (data > root.data) {
            root.right = deleteRec(root.right, data);
        } else {
            // 데이터를 찾았을 때, 세 가지 경우 처리
            // 1. 자식이 없는 경우
            if (root.left == null && root.right == null) {
                return null;
            }
            // 2. 자식이 하나만 있는 경우
            else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // 3. 자식이 두 개 있는 경우
            root.data = minValue(root.right);  // 오른쪽 서브트리에서 가장 작은 값을 가져옴
            root.right = deleteRec(root.right, root.data);  // 오른쪽 서브트리에서 그 값을 삭제
        }
        return root;
    }

    // 오른쪽 서브트리에서 가장 작은 값 찾기
    private int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }
}

