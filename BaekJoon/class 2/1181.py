# 단어 정렬
import sys
input = sys.stdin.readline

n = int(input())
data = set()
for _ in range(n):
    data.add(input().rstrip())

data = list(data)
data.sort(key=lambda x: (len(x), x))
print("\n".join(data))
