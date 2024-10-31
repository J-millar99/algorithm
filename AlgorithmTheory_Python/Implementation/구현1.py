# 상하좌우

# 내 코드
'''
n = int(input())
step = list(input().split())
x, y = 1, 1
for s in step:
    if s == 'R':
        if not y == 5:
            y += 1
    elif s == 'L':
        if not y == 1:
            y -= 1
    elif s == 'U':
        if not x == 1:
            x -= 1
    elif s == 'D':
        if not x == 5:
            x += 1

print(x, y, sep=" ")
'''

# 정답 코드
n = int(input())
x, y = 1, 1
plans = input().split()

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]
steps = ['L', 'R', 'U', 'D']

for plan in plans:
    for i in range(len(steps)):
        if steps[i] == plan:
            nx = x + dx[i]
            ny = y + dy[i]
            break
    if nx < 1 or ny < 1 or nx > n or ny > n:
        continue
    x, y = nx, ny

print(x, y)