import sys
from collections import deque
input = sys.stdin.readline

def bfs(start):
    visited[start] = True
    count = 0
    q = deque([start])
    while q:
        node = q.popleft()
        for v in comp[node]:
            if not visited[v]:
                visited[v] = True
                count += 1
                q.append(v)
    print(count)
        


n = int(input())
comp = [[]for i in range(n + 1)]
visited = [False] * (n + 1)
k = int(input())
for _ in range(k):
    a, b = map(int, input().rstrip().split())
    comp[a].append(b)
    comp[b].append(a)

bfs(1)