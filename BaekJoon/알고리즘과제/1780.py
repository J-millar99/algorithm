# 종이의 개수

# 입력 선언
import sys, math
input = sys.stdin.readline

# 2차원 맵 형성
n = int(input())
matrix = []
for _ in range(n):
    matrix.append(list(map(int, input().rstrip().split())))

ret = {
    -1 : 0,
    0 : 0,
    1 : 0
}

# 알고리즘 구현
def _degenerateCase(_matrix):
    first = _matrix[0][0]
    for row in _matrix:
        for value in row:
            if value != first:
                return False
    return True

def _split(_matrix):
    n = len(_matrix)
    div = n // 3
    _submatrices = []

    for i in range(0, n, div):
        for j in range(0, n, div):
            _submatrix = [row[j:j+div] for row in _matrix[i:i+div]]
            _submatrices.append(_submatrix)
    return _submatrices

def _divide(_matrix):
    if _degenerateCase(_matrix):
        ret[_matrix[0][0]] += 1
        return
    else:
        submatrices = _split(_matrix)
        # 재귀적으로 각 부분 행렬 처리
        for submatrix in submatrices:
            _divide(submatrix)

_divide(matrix)

for r in ret.values():
    print(r)