from collections import deque

def dfs(x, y, step):
    if x < 0 or x >= row or y < 0 or y >= col:
        steps.append(step)
        for _ in range(step):
            _deque.pop()
        return False
    alpha = _matrix[x][y]
    if not alpha in _deque:
        _deque.append(alpha)
        dfs(x - 1, y, step + 1)
        dfs(x + 1, y, step + 1)
        dfs(x, y + 1, step + 1)
        dfs(x, y - 1, step + 1)
        return True
    return False

row, col = map(int, input().split())
_matrix = []
for _ in range(row):
    _matrix.append(list(input()))

steps = []
_deque = deque()
dfs(0, 0, 1)
print(steps)