import sys
input = sys.stdin.readline

n, m = map(int, input().split())
_map = [list(map(int, input().split())) for _ in range(n)]

# 2차원 누적합 배열 만들기
prefixSum = [[0] * (n + 1) for _ in range(n + 1)]

# 누적합 계산
for i in range(1, n + 1):
    for j in range(1, n + 1):
        prefixSum[i][j] = _map[i - 1][j - 1] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1]

# 구간 합 계산
ret = []
for _ in range(m):
    sX, sY, eX, eY = map(int, input().split())
    result = prefixSum[eX][eY] - prefixSum[sX - 1][eY] - prefixSum[eX][sY - 1] + prefixSum[sX - 1][sY - 1]
    ret.append(result)

print("\n".join(map(str, ret)))
