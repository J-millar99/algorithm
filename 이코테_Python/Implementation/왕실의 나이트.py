loc = input()
dir = [(-2, -1), (-2, 1), (2, -1), (2, 1), (-1, -2), (-1, 2), (1, -2), (1, 2)]
count = 0

x = int(loc[1])
y = int(ord(loc[0]) - ord('a') + 1)
print(x,y)
for d in dir:
    nx = x + d[1]
    ny = y + d[0]
    if nx < 1 or ny < 1 or nx > 8 or ny > 8:
        continue
    count += 1

print(count)