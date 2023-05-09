n, m, k = map(int, input().split())
data = sorted(list(map(int, input().split())))
result = 0

cnt = 0
for _ in range(m):
    for _ in range(k):
        result += max(data)
        cnt += 1
        if (cnt == m):
            break
    temp = max(data)
    data.remove(temp)
    result += max(data)
    data.append(temp)
    cnt += 1
    if (cnt == m):
        break

print(result)