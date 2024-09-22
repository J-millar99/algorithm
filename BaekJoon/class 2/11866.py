# 요세푸스 문제 0
from collections import deque
n, k = map(int, input().split())
d = deque()
for i in range(1, n + 1):
    d.append(i)

print("<", end = "")
while len(d) != 0:
    d.rotate(-(k - 1))
    print(d.popleft(), end=", " if len(d) != 0 else "")
print(">")