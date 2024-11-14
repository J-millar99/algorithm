# 뱀과 사다리 게임
import sys
from collections import deque
input = sys.stdin.readline

dice = [1, 2, 3, 4, 5, 6]

def cordinate(value):
    if value % 10 != 0:
        x, y = value // 10, (value % 10) - 1
    else:
        x, y = (value // 10) - 1, 9
    return (x, y)

def bfs():
    q = deque([(1, 0)])
    fp = set([1])
    while q:
        loc, step = q.popleft()
        for i in range(6):
            nloc = loc + dice[i]
            x, y = cordinate(nloc)
            if graph[x][y] == 100:
                return step + 1
            elif graph[x][y] < 100 and nloc not in fp:
                q.append((graph[x][y], step + 1))
                fp.add(graph[x][y])
       

n, m = map(int, input().split())

# 사다리 정보를 딕셔너리에 저장
ladders = {}
for _ in range(n):
    a, b = map(int, input().split())
    ladders[a] = b

# 뱀 위치를 딕셔너리에 저장
snakes = {}
for _ in range(m):
    a, b = map(int, input().split())
    snakes[a] = b

graph = [[] for _ in range(10)]
for i in range(10):
    for j in range(1, 11):
        val = j + 10 * i
        if val in snakes:
            val = snakes[val]
        elif val in ladders:
            val = ladders[val]
        graph[i].append(val)

print(bfs())