n, m = map(int, input().split())
x, y, d = map(int, input().split())
di = [list(map(int, input().split())) for _ in range(n)]
di[x][y] = 2
cnt = 1

while True:
    if d == 0 and di[x-1][y] == 0:
        x -= 1
    elif d == 0 and di[x-1][y] != 0:
        d = 3
    if d == 1 and di[x][y+1] == 0:
        y += 1
    elif d == 1 and di[x][y+1] != 0:
        d = 0
    if d == 2 and di[x+1][y] == 0:
        x += 1
    elif d == 2 and di[x+1][y] != 0:
        d = 1
    if d == 3 and di[x][y-1] == 0:
        y -= 1
    elif d == 3 and di[x][y-1] != 0:
        d = 2
    if di[x][y] == 0:
        di[x][y] = 2
        cnt += 1
    if di[x-1][y] != 0 and di[x][y+1] != 0 and di[x+1][y] != 0 and di[x][y-1] != 0:
        if d == 0:
            if di[x+1][y] == 2:
                x += 1
            else:
                break
        elif d == 1:
            if di[x][y-1] == 2:
                y -= 1
            else:
                break
        elif d == 2:
            if di[x-1][y] == 2:
                x -= 1
            else:
                break
        elif d == 3:
            if di[x][y+1] == 2:
                y += 1
            else:
                break
print(cnt)