import sys
input = sys.stdin.readline
n = int(input())
ret = []
stack = []
for _ in range(n):
    cmd = input().rstrip()
    if "push" in cmd:
        stack.append(cmd[5:])
    elif cmd == "pop":
        ret.append(stack.pop() if len(stack) else "-1")
    elif cmd == "size":
        ret.append(str(len(stack)))
    elif cmd == "empty":
        ret.append("1" if len(stack) == 0 else "0")
    elif cmd == "top":
        ret.append(stack[-1] if len(stack) else "-1")

print("\n".join(ret))