# 색종이 만들기
import sys

input = sys.stdin.readline
n = int(input())
matrix = [list(input().rstrip().split()) for _ in range(n)]

bcnt, wcnt = 0, 0
def cutPaper(x, y, size):
    global bcnt, wcnt
    if all(matrix[i][j] == '1' for i in range(x, x + size) for j in range(y, y + size)):
        bcnt += 1
    elif all(matrix[i][j] == '0' for i in range(x, x + size) for j in range(y, y + size)):
        wcnt += 1
    else:
        size = int(size / 2)
        cutPaper(x, y, size) # 좌 상단
        cutPaper(x, y + size, size) # 우 상단
        cutPaper(x + size, y, size) # 좌 하단
        cutPaper(x + size, y + size, size) # 우 하단
cutPaper(0, 0, n)
print(wcnt, bcnt, sep="\n")