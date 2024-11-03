# 말이 되고픈 원숭이
import sys
from collections import deque

mstep = [(0, -1), (-1, 0), (0, 1), (1, 0)]
hstep = [(1, 2), (-1, 2), (1, -2), (-1, -2), (2, 1), (-2, 1), (2, -1), (-2, -1)]

input = sys.stdin.readline
k = int(input())
w, h = map(int, input().split())

graph = []
for _ in range(h):
    graph.append(list(map(int, input().split())))

def bfs(k):
    q = deque([(0, 0 ,0, k)])
    visit = set()  # 방문 처리 집합
    visit.add((0, 0, k))  # 초기 위치와 남은 말 이동 횟수 추가
    steps = []
    while q:
        x, y, step, remain = q.popleft()
        if x == h - 1 and y == w - 1:
            return step
        
        # 말의 이동
        if remain > 0:
            for dx, dy in hstep:
                nx, ny = x + dx, y + dy
                if 0 <= nx < h and 0 <= ny < w and graph[nx][ny] == 0 and (nx, ny, remain - 1) not in visit:
                    visit.add((nx, ny, remain - 1))
                    q.append((nx, ny, step + 1, remain - 1))
        
        # 일반 이동
        for dx, dy in mstep:
            nx, ny = x + dx, y + dy
            if 0 <= nx < h and 0 <= ny < w and graph[nx][ny] == 0 and (nx, ny, remain) not in visit:
                visit.add((nx, ny, remain))
                q.append((nx, ny, step + 1, remain))

    return -1  # 경로가 없으면 -1 반환
print(bfs(k))