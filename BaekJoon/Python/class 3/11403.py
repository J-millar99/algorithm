# 경로 찾기
import sys
input = sys.stdin.readline
INF = int(1e9)

n = int(input())
graph = [[INF] * (n + 1) for _ in range(n + 1)]
_map = []
for _ in range(n):
    _map.append(list(map(int, input().split())))

for a in range(n):
    for b in range(n):
        if _map[a][b] == 1:
            graph[a][b] = 1

for k in range(n):
    for a in range(n):
        for b in range(n):
            graph[a][b] =  min(graph[a][b], graph[a][k] + graph[k][b])

# 수행된 결과를 출력
for a in range(n):
    for b in range(n):
        # 도달할 수 없는 경우, 무한이라고 출력
        if graph[a][b] == INF:
            print("0", end=" ")
        else:
            print("1", end=" ")
    print()