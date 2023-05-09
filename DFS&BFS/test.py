n, m = map(int, input().split())
data = list(input() for _ in range(n))
global dm
dm = [[] for _ in range(n)]

for i in range(n):
    for j in range(m):
        dm[i].append(int(data[i][j]))