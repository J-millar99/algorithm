# 트리 순회
import sys
input = sys.stdin.readline
n = int(input())
tree = [[] for _ in range(n)]
for i in range(n):
    root, left, right = input().rstrip().split()
    tree[ord(root) - ord('A')].append(left)
    tree[ord(root) - ord('A')].append(right)

def preorder(tree, i):
    print(chr(i + ord('A')), end="")
    left = tree[i][0]
    right = tree[i][1]
    if left != ".": # 왼쪽 자식노드가 존재하면
        preorder(tree, ord(left) - ord('A'))
    if right != ".": # 오른쪽 자식 노드가 존재하면
        preorder(tree, ord(right) - ord('A'))

def inorder(tree, i):
    left = tree[i][0]
    right = tree[i][1]
    if left != ".": # 왼쪽 자식노드가 존재하면
        inorder(tree, ord(left) - ord('A'))
    print(chr(i + ord('A')), end="")
    if right != ".": # 오른쪽 자식 노드가 존재하면
        inorder(tree, ord(right) - ord('A'))

def postorder(tree, i):
    left = tree[i][0]
    right = tree[i][1]
    if left != ".": # 왼쪽 자식노드가 존재하면
        postorder(tree, ord(left) - ord('A'))
    if right != ".": # 오른쪽 자식 노드가 존재하면
        postorder(tree, ord(right) - ord('A'))
    print(chr(i + ord('A')), end="")

preorder(tree, 0)
print()
inorder(tree, 0)
print()
postorder(tree, 0)