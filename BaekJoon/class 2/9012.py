n = int(input())
ret = []

for _ in range(n):
    stack = []
    bracket = input()
    for b in bracket:
        stack.append(b)
        if len(stack) >= 2:
            if stack[-1] == ")" and stack[-2] == "(":
                stack.pop()
                stack.pop()
    if not stack:
        ret.append("YES")
    else:
        ret.append("NO")

print("\n".join(ret))