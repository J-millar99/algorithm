import sys
input = sys.stdin.readline

# 입력: 맵 크기
n, m = map(int, input().rstrip().split())

# 2차원 그래프 형성
graph = []
for _ in range(n):
    graph.append(list(map(int, input().rstrip())))

def dfs(x, y):
    if x < 0 or x >= n or y < 0 or y >= m:
        return False
    if graph[x][y] == 0:
        graph[x][y] = 1
        dfs(x - 1, y)
        dfs(x + 1, y)
        dfs(x, y + 1)
        dfs(x, y - 1)
        return True
    return False

count = 0

for i in range(n):
    for j in range(m):
        if dfs(i, j) == True:
            count += 1

print(count)