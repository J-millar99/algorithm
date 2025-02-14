# 트리의 부모
from collections import deque
import sys
input = sys.stdin.readline
n = int(input())
tree = [[] for _ in range(n + 1)]

def bfs(v):
    q = deque([v])
    visited = [False] * (n + 1)
    parent = [[] for _ in range(n + 1)]
    while q:
        root = q.popleft()
        visited[root] = True
        for child in tree[root]:
            if not visited[child]:
                visited[child] = True
                parent[child].append(root)
                q.append(child)
    return parent

for _ in range(n - 1):
    n1, n2 = map(int, input().rstrip().split())
    tree[n1].append(n2)
    tree[n2].append(n1)
        
ret = bfs(1)

for r in ret:
    if r:
        print(r[0])
