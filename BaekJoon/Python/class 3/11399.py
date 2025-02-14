# ATM
n = int(input())
data = list(map(int, input().split()))
ret = []
total = 0
data.sort()
for d in data:
    total += d
    ret.append(total)

print(sum(ret))