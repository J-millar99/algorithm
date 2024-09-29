# Z

# 입력 선언
import sys, math
input = sys.stdin.readline

# 입력 받기
size, r, c = map(int, input().rstrip().split())
matrix = [[0 for i in range(2 ** size)] for _ in range(2 ** size)]

def _degenerateCase(_matrix):
    if len(_matrix) == 2:
        return True   
    return False

def _split(_matrix):
    n = len(_matrix)
    div = n // 2
    _submatrices = []

    for i in range(0, n, div):
        for j in range(0, n, div):
            _submatrix = [row[j:j+div] for row in _matrix[i:i+div]]
            _submatrices.append(_submatrix)
    return _submatrices
Z = 0
def _divide(_matrix):
    global Z
    if _degenerateCase(_matrix):
        Z += 1
        return
    else:
        submatrices = _split(_matrix)
        for submatrix in submatrices:
            _divide(submatrix)

_divide(matrix)
print(Z)