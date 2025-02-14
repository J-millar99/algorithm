# 구간 합 구하기 4
import sys
input = sys.stdin.readline

n, m = map(int, input().rstrip().split())
data = list(map(int, input().rstrip().split()))
prefix_sum = [0] * (n + 1)

for i in range(1, n + 1):
    prefix_sum[i] = prefix_sum[i - 1] + data[i - 1]

for _ in range(m):
    x, y = map(int, input().rstrip().split())
    print(prefix_sum[y] - prefix_sum[x - 1])