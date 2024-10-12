# 비재귀 dfs
from collections import deque
import sys
input = sys.stdin.readline

def bfs():
    # 큐에 초기 상태 (좌표 x, 좌표 y, 현재까지 이동한 칸 수 count, 방문한 알파벳 상태 visited)를 넣음
    queue = deque([(0, 0, 1, 1 << (ord(_matrix[0][0]) - ord('A')))])
    max_count = 1

    while queue:
        x, y, count, visited = queue.popleft()
        max_count = max(max_count, count)
        
        # 네 방향으로 이동
        for dx, dy in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
            nx, ny = x + dx, y + dy
            if 0 <= nx < row and 0 <= ny < col:
                next_alpha = ord(_matrix[nx][ny]) - ord('A')
                # 새로운 알파벳을 아직 방문하지 않았을 때
                if not (visited & (1 << next_alpha)):
                    # 큐에 새로운 상태를 추가
                    queue.append((nx, ny, count + 1, visited | (1 << next_alpha)))

    return max_count

# 입력 처리
row, col = map(int, input().rstrip().split())
_matrix = [list(input().rstrip()) for _ in range(row)]

# BFS로 최대 이동 칸 수 계산
print(bfs())
