# 단지번호 붙이기
import sys
from collections import deque
input = sys.stdin.readline
n = int(input())
graph = []
for _ in range(n):
    graph.append(list(input().rstrip()))
    
def dfs(x, y):
    global val
    if not (0 <= x < n and 0 <= y < n):
        return False
    if graph[x][y] == '1':
        val += 1
        graph[x][y] = '0' # 방문처리
        dfs(x + 1, y)
        dfs(x, y + 1)
        dfs(x - 1, y)
        dfs(x, y - 1)
        return True
    return False        
    
ret = 0
val = 0
data = []
for i in range(n):
    for j in range(n):
        if graph[i][j] != '0' and dfs(i, j) == True:
            ret += 1
            data.append(val)
            val = 0

print(ret)
data.sort()
for d in data:
    print(d)