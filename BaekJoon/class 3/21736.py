# 헌내기는 친구가 필요해
import sys
from collections import deque
input = sys.stdin.readline
n, m = map(int, (input().split()))

dx = [-1, 1, 0, 0]
dy = [0, 0, 1, -1]
symbol = ['X', 'I']

def bfs(x, y):
    ret = 0
    q = deque([(x, y)])
    while q:
        mx, my = q.popleft()
        for i in range(4):
            nx = mx + dx[i]
            ny = my + dy[i]
            if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] not in symbol:
                if graph[nx][ny] == 'P':
                    ret += 1
                graph[nx][ny] = 'I'
                q.append((nx, ny))
    if ret:
        return ret
    return 'TT'
                
graph = []
x, y = 0, 0     # 도연이의 위치
found = False   # 'I'의 위치를 기록하기 위함

# 입력받기
for i in range(n):
    line = list(input().rstrip())
    if not found and 'I' in line:
        x, y = i, line.index('I')
        found = True
    graph.append(line)

print(bfs(x, y))