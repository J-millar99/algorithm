# 큐
from collections import deque
import sys
input = sys.stdin.readline
n = int(input())
ret = []
q = deque()
for _ in range(n):
    cmd = input().rstrip()
    if "push" in cmd:
        q.append(cmd[5:])
    elif cmd == "pop":
        ret.append(q.popleft() if len(q) else "-1")
    elif cmd == "size":
        ret.append(str(len(q)))
    elif cmd == "empty":
        ret.append("1" if len(q) == 0 else "0")
    elif cmd == "front":
        ret.append(q[0] if len(q) else "-1")
    elif cmd == "back":
        ret.append(q[-1] if len(q) else "-1")

print("\n".join(ret))