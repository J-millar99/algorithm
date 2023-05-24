N, M = map(int, input().split())
rice = list(map(int, input().split()))

for i in range(1, max(rice)):
    result = 0
    for j in rice:
        if j - i < 0:
            continue
        result += j - i
    if result == M:
        break

print(i)