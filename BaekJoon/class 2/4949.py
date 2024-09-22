# 균형잡힌 세상
ret = []

while True:
    bracket = input()
    if bracket == ".":
        break
    stack = []
    for b in bracket:
        if b in "([])":
            stack.append(b)
        if len(stack) >= 2:
            if stack[-1] == ")" and stack[-2] == "(":
                stack.pop()
                stack.pop()
            elif stack[-1] == "]" and stack[-2] == "[":
                stack.pop()
                stack.pop()
    if not stack:
        ret.append("yes")
    else:
        ret.append("no")

print("\n".join(ret))