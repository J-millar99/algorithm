# 미로 탐색
import sys
from collections import deque
input = sys.stdin.readline
n, m = map(int, (input().split()))

dx = [-1, 1, 0, 0]
dy = [0, 0, 1, -1]

def bfs(x, y):
    q = deque([(x, y, 1)])
    ret = []
    while q:
        mx, my, step = q.popleft()
        for i in range(4):
            nx = mx + dx[i]
            ny = my + dy[i]
            if nx == n - 1 and ny == m - 1:
                ret.append(step + 1)
                break
            if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] != '0':
                graph[nx][ny] = '0'
                q.append((nx, ny, step + 1))

    return ret
                
graph = []
# 입력받기
for i in range(n):
    line = list(input().rstrip())
    graph.append(line)

print(min(bfs(0, 0)))