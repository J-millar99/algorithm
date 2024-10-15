import sys
input = sys.stdin.readline
row, col = map(int, input().rstrip().split())
d = [[-1, 0], [1, 0], [0, -1], [0, 1]] # 방향 벡터

def matrix_subtraction(matrix1, matrix2):
    # 행렬의 크기 확인
    if len(matrix1) != len(matrix2) or len(matrix1[0]) != len(matrix2[0]):
        raise ValueError("두 행렬의 크기가 같아야 합니다.")
    
    # 결과 행렬 초기화
    result = []
    
    for i in range(len(matrix1)):
        row = []
        for j in range(len(matrix1[0])):
            row.append(matrix1[i][j] - matrix2[i][j])
        result.append(row)
    
    return result

def _melt(x, y):
    for dx, dy in d:
        nx = x + dx
        ny = y + dy
        if nx < 0 or nx >= row or ny < 0 or ny >= col:
            continue
        if _matrix[nx][ny] == 0:
            _wmap[x][y] -= 1

#빙산이 분리되어 있는지 확인
def _check(x, y): 
    for dx, dy in d:
        nx = x + dx
        ny = y + dy
        if nx < 0 or nx >= row or ny < 0 or ny >= col:
            continue
        if _matrix[nx][ny] != 0: # 빙산의 상하좌우가 모두 0 인 경우에 return 0
            return False
    return True

def print_2d_map(matrix):
    print()
    for row in matrix:
        print(" ".join(map(str, row)))

def _time():
    global count
    temp = 0

    # 빙산 녹이기
    for i in range(row):
        for j in range(col):
            if _matrix[i][j] == 0:
                temp += 1
                continue
            _melt(i, j)

    # 빙산이 모두 녹았다면 0
    if temp == row * col:
        return 0
    _matrix = matrix_subtraction(_matrix, _wmap)
    # 빙산이 모두 녹지 않았다면 year = +1
    count += 1

    # 빙산이 분리되었는지 확인
    for i in range(row):
        for j in range(col):
            if _matrix[i][j] == 0:
                continue
            if _check(i, j):
                return count
    _time()

# 맵 선언
_matrix = []
for _ in range(row):
    arr = list(map(int, input().rstrip().split()))
    _matrix.append(arr)
_wmap = _matrix
count = 0
print(_time())