# 동전 0
import sys
input = sys.stdin.readline
n, k = map(int, input().rstrip().split())
d = []
for _ in range(n):
    coin = input().rstrip()
    d.append(coin)
idx = n - 1
while idx != -1:
    val = k // coin[idx]
    coin