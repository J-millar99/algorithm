N = int(input())
nl = sorted(list(map(int, input().split())))
group = 0
temp = 0
i = 0

while i < N:
    j = 0
    cnt = 0
    for j in range(N):
        if nl[i] == nl[j]:
            temp += 1
            if (temp == nl[i]):
                group += 1
                temp = 0
            cnt += 1
    i += cnt
print(group)