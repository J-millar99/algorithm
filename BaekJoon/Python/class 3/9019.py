# DSLR (pypy3)
import sys
from collections import deque
input = sys.stdin.readline

for _ in range(int(input())):
    srcs, dest = map(int, input().rstrip().split())
    visit = dict()
    cmd = dict()
    visit[srcs] = srcs
    q = deque([(srcs)])
    while q:
        src = q.popleft()

        if src == dest:
            track = []
            while src != srcs:
                track.append(cmd[src])
                src = visit[src]
            for i in range(len(track)-1,-1,-1):
                print(track[i],end='')
            print('')
            break

        # D
        A = (src * 2) % 10000
        if visit[A] == 0:
            q.append(A)
            visit[A] = src
            cmd[A] = 'D'

        # S
        A = src - 1 if src != 0 else 9999
        if visit[A] == 0:
            q.append(A)     
            visit[A] = src
            cmd[A] = 'S'
        # L
        A = ((src % 1000) * 10) + (src // 1000)
        if visit[A] == 0:
            q.append(A)
            visit[A] = src
            cmd[A] = 'L'
        # R
        A = ((src % 10) * 1000) + (src // 10)
        if visit[A] == 0:
            q.append(A)
            visit[A] = src
            cmd[A] = 'R'