# 빙산
import sys
input = sys.stdin.readline

row, col = map(int, input().rstrip().split())

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def _melt():
    melt_list = []
    for i in range(1, row - 1):
        for j in range(1, col - 1):
            if _matrix[i][j] > 0:
                melt_count = 0
                for k in range(4):
                    nx = i + dx[k]
                    ny = j + dy[k]
                    if _matrix[nx][ny] == 0:
                        melt_count += 1
                if melt_count > 0:
                    melt_list.append((i, j, melt_count))

    for x, y, melt_count in melt_list:
        _matrix[x][y] = max(0, _matrix[x][y] - melt_count)

def dfs_iterative(temp, x, y):
    if temp[x][y] == 0:
        return False
    stack = [(x, y)]
    while stack:
        x, y = stack.pop()
        if temp[x][y] == 0:
            continue
        temp[x][y] = 0
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < row and 0 <= ny < col and temp[nx][ny] != 0:
                stack.append((nx, ny)) 
    return True

# 빙산이 분리되어 있는지 확인
def _divide():
    temp = [row[:] for row in _matrix]  # 깊은 복사 대신 리스트 복사 방식
    count = 0
    for i in range(1, row - 1):
        for j in range(1, col - 1):
            if dfs_iterative(temp, i, j):
                count += 1
            if count == 2:
                return True
    return False

def _time():
    global year, _matrix

    while True:
        # 빙산이 분리되었는지 확인
        if _divide(): return
        _melt()
        # 빙산이 모두 녹았다면 0
        if all(_matrix[i][j] == 0 for i in range(1, row - 1) for j in range(1, col - 1)):
            year = 0
            return
        year += 1

# 맵 선언
_matrix = [list(map(int, input().rstrip().split())) for _ in range(row)]

year = 0
_time()
print(year)
