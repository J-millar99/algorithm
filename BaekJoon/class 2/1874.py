# 스택 수열
import sys
from collections import deque
input = sys.stdin.readline
n = int(input())
srcs = [int(input()) for _ in range(n)] # 입력된 수열
origin = deque(sorted(srcs))

data1 = []
data2 = []
ret = []
i = 0
while True:
    while origin[0] != srcs[i]:
        data1.append(origin.popleft()) # 같기 직전까지 넣기
        ret.append("+")
        if not origin:
            break
    if origin:
        data1.append(origin.popleft())
        ret.append("+")
    while data1[-1] == srcs[i]:
        data2.append(data1.pop())
        ret.append("-")
        i += 1
        if not data1:
            break
    if not origin:
        break

if data2 == srcs:
    print("\n".join(ret))
else:
    print("NO")