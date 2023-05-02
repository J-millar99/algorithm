n = int(input())
data = list(input().split())
x, y = 1, 1

for d in data:
    if d == 'R':
        y += 1
        if y > n:
            y = n
    elif d == 'U':
        x -= 1
        if x < 1:
            x = 1
    elif d == 'D':
        x += 1
        if x > n:
            x = n
    elif d == 'L':
        y -= 1
        if y < 1:
            y = 1

print(x, y)