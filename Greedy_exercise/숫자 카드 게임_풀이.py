n, m = map(int, input().split())
data = [list(map(int, input().split())) for _ in range(n)]
result = min(data[0])

for i in range (1, n):
    if result < min(data[i]):
        result = min(data[i])

print(result)