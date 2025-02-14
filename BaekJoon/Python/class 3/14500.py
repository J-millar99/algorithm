# 테트로미노
import sys
input = sys.stdin.readline
n, m = map(int, input().split())

graph = []
for _ in range(n):
    graph.append(list(map(int, input().split())))

# 대칭은 함수로
def axisSymmetry(shape):
    # 반환 배열
    sym_shapes = []
    # 원점대칭을 위한 변수
    min_x, min_y = 0, 0

    # 초기 모양
    temp = []
    for dx, dy in shape:
        temp.append([dx, dy])
    sym_shapes.append(temp)

    # x축 대칭
    temp = []
    for dx, dy in shape:
        temp.append([dx, -dy])
        min_y = min(min_y, -dy)
    for i in range(4):
        temp[i][1] += -min_y
    sym_shapes.append(temp)

    # y축 대칭
    temp = []
    for dx, dy in shape:
        temp.append([-dx, dy])
        min_x = min(min_x, -dx)
    for i in range(4):
        temp[i][0] += -min_x
    sym_shapes.append(temp)

    # x, y(점) 대칭
    temp = []
    min_x, min_y = 0, 0
    for dx, dy in shape:
        min_x = min(min_x, -dx)
        min_y = min(min_y, -dy)
        temp.append([-dx, -dy])
    for i in range(4):
        temp[i][0] += -min_x
        temp[i][1] += -min_y
    sym_shapes.append(temp)

    return sym_shapes

# 회전 도형만 포함
shape = [
    # I미노
    [(0, 0), (0, 1), (0, 2), (0, 3)],
    [(0, 0), (1, 0), (2, 0), (3, 0)],

    # O미노
    [(0, 0), (0, 1), (1, 0), (1, 1)],

    # L미노
    [(0, 0), (1, 0), (2, 0), (2, 1)],
    [(0, 0), (1, 0), (0, 1), (0, 2)],

    # Z미노
    [(0, 0), (1, 0), (1, 1), (2, 1)],
    [(0, 0), (0, 1), (1, 1), (1, 2)],

    # T미노
    [(0, 0), (0, 1), (0, 2), (1, 1)],
    [(0, 0), (1, 0), (1, 1), (2, 0)],
]

def lay(cord) :
    global total
    x, y = 0, -1
    while x != n:
        _sum = 0
        y += 1
        if y == m:
            y = 0
            x += 1
        sub = []
        for dx, dy in cord:
            nx, ny = x + dx, y + dy
            if 0 <= nx < n and 0 <= ny < m:
                sub.append((nx, ny))
        if len(sub) == 4:
            for _x, _y in sub:
                _sum += graph[_x][_y]
            total = max(total, _sum)


total = 0
for i in range(9):
    choice = shape[i]
    if i < 3:
        lay(choice)
    else:
        axisChoices = axisSymmetry(choice)
        for axisChoice in axisChoices:
            lay(axisChoice)
    
print(total)
