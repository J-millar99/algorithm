# 마인크래프트
import sys
input = sys.stdin.readline
n, m, b = map(int, input().split())

graph = []
# 바닥과 천장
floor, ceil = 257, -1
for _ in range(n):
    temp = list(map(int, input().split()))
    graph.append(temp)

# 최대 높이 블럭
ceil = max(max(row) for row in graph)
floor = min(min(row) for row in graph)
             
time = 0   
while True:
    # 평평한지 확인
    if ceil == floor:
        break
    # 바닥 쌓기가 가능한지 확인
    pile, dig = [], []
    for i in range(n):
        for j in range(m):
            if graph[i][j] == floor:
                pile.append((i, j))
            elif graph[i][j] == ceil:
                dig.append((i, j))
    p = len(pile)
    q = len(dig)
    if b >= p:
        # 쌓아야 함
        if p < 2 * q:
            for x, y in pile:
                graph[x][y] += 1
            b -= p
            floor += 1
            time += p
        # 파야함
        else:
            for x, y in dig:
                graph[x][y] -= 1
            ceil -= 1
            b += q
            time += 2 * q
    else:
        for x, y in dig:
            graph[x][y] -= 1
        b += q
        ceil -= 1
        time += 2 * q 
        
print(time, ceil, sep=" ")