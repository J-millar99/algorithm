from collections import deque
import sys
input = sys.stdin.readline

# 입력: 맵 크기
n, m = map(int, input().rstrip().split())

# 2차원 그래프 형성
graph = []
for _ in range(n):
    graph.append(list(map(int, input().rstrip())))

dx = [-1, 0, 0, 1]
dy = [0, -1, 1, 0]

def bfs(x, y):
    queue = deque([(x, y)])
    # 큐가 빌 때까지 반복
    while queue:
        x, y = queue.popleft()
        # 큐에서 하나의 원소를 확인
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            # 공간 밖인 경우 무시
            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue
            # 괴물 지점인 경우 무시
            if graph[nx][ny] == 0:
                continue
            # 처음 방문한 경우에 거리를 기록
            if graph[nx][ny] == 1:
                graph[nx][ny] += graph[x][y]
                queue.append((nx, ny))
    # 탐색을 모두 끝낸 후, 출구 위치의 거리를 반환
    return (graph[n - 1][m - 1])
print(bfs(0, 0))