N, x = map(int, input().split())
data = list(map(int, input().split()))

result = data.count(x)
if result == 0:
    result = -1
print(result)

