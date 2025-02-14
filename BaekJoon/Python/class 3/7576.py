# 토마토
import sys
from collections import deque
input = sys.stdin.readline

dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]

def _check():
    # 모두 익은 경우
    if all(graph[i][j] == 1 or graph[i][j] == -1 
           for i in range(n) for j in range(m)):
        return True
    return False

# bfs
def _simulate():
    # day는 0부터 시작
    day = 0
    # 처음 상태에서 모두 익은 상태인지 확인
    if _check():
        return day

    q = deque()
    # 익은 토마토의 위치를 저장
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 1:
                q.append((i, j))
    while True:
        a = deque()
        while q:
            x, y = q.popleft()
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] == 0:
                    graph[nx][ny] = 1
                    a.append((nx, ny))
        q = a
        if not q:
            break
        day += 1

    if _check():
        return day # 모두 익었다면 day를 반환 (-1을 해주는 이유는 익은 후에 수를 세기 때문)
    else:
        return -1   # 모두 익지 않았다면 -1을 반환
    
m, n = map(int, input().split())
graph = []
for _ in range(n):
    graph.append(list(map(int, input().split())))


print(_simulate())