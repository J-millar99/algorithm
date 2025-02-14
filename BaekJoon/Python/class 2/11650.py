# 좌표 정렬하기
import sys
input = sys.stdin.readline
n = int(input())

data = []
for _ in range(n):
    x, y = map(int, input().rstrip().split())
    data.append([x, y])

data.sort(key=lambda d: (d[0], d[1]))
for a, b in data:
    print(a, b)