start = input()
move_types = [(-2, -1), (-2, 1), (2, -1), (2, 1), (1, 2), (-1, 2), (1, -2), (-1, -2)]
cnt = 0

x = ord(start[0])   #행 (아스키코드로 변환)
y = int(start[1])   #열
for i in range(len(move_types)):
    dx = x + move_types[i][0]
    dy = y + move_types[i][1]
    if (ord('a') <= dx <= ord('h')) and (1 <= dy <= 8):
        cnt += 1

print(cnt)