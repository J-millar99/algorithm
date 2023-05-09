n, m = map(int, input().split())

result = 0
for i in range(n):
    data = list(map(int, input().split()))
    min_value = 0
    for a in data:
        min_value = min(a, min_value)
    result = max(result, min_value)

print(result)