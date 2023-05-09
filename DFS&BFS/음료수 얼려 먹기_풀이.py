n, m = map(int, input().split())
data = list(input() for _ in range(n))
global dm
dm = [[] for _ in range(n)]

for i in range(n):
    for j in range(m):
        dm[i].append(int(data[i][j]))
cnt = 0

def ice(dm, i, j):
    dm[i][j] = 2
    if j < m - 1 and dm[i][j + 1] == 0:
        ice(dm, i, j + 1)
    if i < n - 1 and dm[i + 1][j] == 0:
        ice(dm, i + 1, j)
    if 1 < j and dm[i][j - 1] == 0:
        ice(dm, i, j - 1)
    if 1 < i and dm[i - 1][j] == 0:
        ice(dm, i - 1, j)  
for i in range(n):
    for j in range(m):
        if dm[i][j] == 0:
            ice(dm, i, j)
            cnt += 1
print(cnt)