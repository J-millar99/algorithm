# 쉬운 최단거리
import sys
from collections import deque
input = sys.stdin.readline
graph = []

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(r, c, step):
    q = deque([(r, c, step)])
    while q:
        x, y, step = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < row and 0 <= ny < col:
                if graph[nx][ny] == 1: # 밟을 수 있는 지점
                    q.append((nx, ny, step + 1))
                    graph[nx][ny] = step + 1

def adjust(r, c):
    for i in range(row):
        for j in range(col):
            if graph[i][j] == 1:
                graph[i][j] = -1
    graph[r][c] = 0
    for i in range(4):
        nx = r + dx[i]
        ny = c + dy[i]
        if 0 <= nx < row and 0 <= ny < col:    
            if graph[nx][ny] != 0: # 밟았던 지점
                graph[nx][ny] = 1
row, col = map(int, input().split())
r2, c2 = 0, 0
for _ in range(row):
    g = list(map(int, input().split()))
    if 2 in g:
        r2 = _
        c2 = g.index(2)
    graph.append(g)

bfs(r2, c2, 0)
adjust(r2, c2)
for i in range(row):
    for j in range(col):
        print(graph[i][j], end=" ")
    print()
