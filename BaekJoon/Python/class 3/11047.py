# 동전 0
import sys
input = sys.stdin.readline
n, k = map(int, input().rstrip().split())
d = []
for _ in range(n):
    coin = input().rstrip()
    d.append(int(coin))
idx = n - 1
count = 0
while True:
    count += k // d[idx]
    k %= d[idx]
    if k == 0:
        break
    idx -= 1
print(count)