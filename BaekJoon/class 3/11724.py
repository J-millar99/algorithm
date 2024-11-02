# 연결 요소의 개수
import sys
from collections import deque
input = sys.stdin.readline

v, e = map(int, input().split())
al = [[] for _ in range(v + 1)]
visited = [False] * (v + 1)
cnt = 0

def bfs(s):
    global cnt
    q = deque([s])
    if visited[s] == False:
        cnt += 1
        visited[s] = True
    else:
        return
    while q:
        v = q.popleft()
        for i in al[v]:
            if visited[i] == False:
                visited[i] = True
                q.append(i)

for _ in range(e):
    a, b = map(int, input().split())
    al[a].append(b)
    al[b].append(a)
    
for i in range(1, v + 1):
    bfs(i)

print(cnt)