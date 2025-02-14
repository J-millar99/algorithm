# 수 정렬하기 2
import sys
input = sys.stdin.readline
n = int(input())
data = []
for _ in range(n):
    data.append(int(input().rstrip()))

data.sort()
print("\n".join(list(map(str, data))))