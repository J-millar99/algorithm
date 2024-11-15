# 사탕 가게
import sys, heapq
input = sys.stdin.readline

while True:
    # 사탕 개수와 돈
    n, m = map(input().split())
    if n == '0':
        break

    menu = []
    # 칼로리와 가격
    for _ in range(n):
        c, p = map(input().split())
        c = int(c), p = float(p)
        menu.append((c, p))

    # 각 사탕에 대해서
    for c, p in menu:
        if (p <= m): # 해당 사탕을 구매할 수 있다면
            if (c + )

    