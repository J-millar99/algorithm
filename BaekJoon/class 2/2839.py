# 설탕 배달
n = int(input())
data = []

i = 0
while 3 * i <= n:
    j = 0
    while (3 * i) + (5 * j) <= n:
        if (3 * i) + (5 * j) == n:
            data.append(i + j)
        j += 1
    i += 1

if data:
    print(min(data))
else:
    print(-1)