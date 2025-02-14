# 적록색약
import sys
sys.setrecursionlimit(100000)
n = int(input())

def blindness(x, y, pivot):
    # Blue가 아니라면 Red로 통일
    if pivot != 'B':
        pivot = 'R'
    if 0 <= x < n and 0 <= y < n and graph[x][y] != 'B':
        graph[x][y] = 'R'
    if 0 <= x < n and 0 <= y < n and graph[x][y] == pivot and vistited_b[x][y] is False:
        vistited_b[x][y] = True
        blindness(x - 1, y, pivot)
        blindness(x + 1, y, pivot)
        blindness(x, y + 1, pivot)
        blindness(x, y - 1, pivot)
        return True
    return False

def vision(x, y, pivot):
    if 0 <= x < n and 0 <= y < n and graph[x][y] == pivot and vistited_v[x][y] is False:
        vistited_v[x][y] = True
        vision(x - 1, y, pivot)
        vision(x + 1, y, pivot)
        vision(x, y + 1, pivot)
        vision(x, y - 1, pivot)
        return True
    return False

vistited_v = [[False for _ in range(n)] for _ in range(n)]
vistited_b = [[False for _ in range(n)] for _ in range(n)]
graph = [list(input().rstrip()) for _ in range(n)]

vcnt, bcnt = 0, 0
for i in range(n):
    for j in range(n):
        if vision(i, j, graph[i][j]) == True:
            vcnt += 1
            
for i in range(n):
    for j in range(n):
        if blindness(i, j, graph[i][j]) == True:
            bcnt += 1

print(vcnt, bcnt, sep=" ")