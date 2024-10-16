# 최대 힙
import sys, heapq
input = sys.stdin.readline
hq = []
for _ in range(int(input())):
    n = int(input())
    if n != 0:
        heapq.heappush(hq, n * -1)
    else:
        if len(hq):
            print(-heapq.heappop(hq))
        else:
            print(0)
