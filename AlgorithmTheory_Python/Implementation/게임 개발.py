n, m = map(int, input().split())
x, y, d = map(int, input().split())
step = [(0, -1), (-1, 0), (0, 1), (1, 0)] # 인덱스는 바라보는 방향, 튜플은 바라보는 방향의 왼쪽
# 북0, 동1, 남2, 서3
dir = [0, 3, 2, 1]
# 회전은 북 서 남 동
_map = []
for _ in range(m):
    _map.append(list(map(int, input().split())))

def turn_left():
    global dir
    idx = dir.index(d) + 1 # 왼쪽 방향으로 조정
    if idx > 3: # 리스트 범위를 넘는다면
        idx = 0 # 범위 초기화
    return idx

count = 1
rotate = 0

while True:
    _map[x][y] = 2 # 현재 지역 방문처리
    nx = x + step[d][0] # 세로 이동방향 계산
    ny = y + step[d][1] # 가로 이동방향 계산
    if _map[nx][ny] != 0: # 해당지역이 이미 방문했거나 바다라면
        rotate_dir = dir[turn_left()] # 회전방향 계산
        d = rotate_dir # 방향 회전 적용
        rotate += 1 # 회전 수
        if rotate == 4: # 한 바퀴 돌았다면
            rotate_dir = dir[turn_left()] # 현재 회전 방향에서 한 번 더 회전, 즉 뒤를 바라봄
            nx = x + step[rotate_dir][0] # 뒤 방향 계산
            ny = y + step[rotate_dir][1]
            if _map[nx][ny] == 1: # 뒤로간 곳이 바다면 멈춤
                break
            else:
                x, y = nx, ny
                rotate = 0
    else: # 방문할 수 있다면 좌표를 이동하고 걸음 수를 기록
        d = dir[turn_left()]
        x, y = nx, ny
        count += 1
        rotate = 0
        
print(count)
