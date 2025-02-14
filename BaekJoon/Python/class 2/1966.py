# 프린터 큐
import sys
from collections import deque
input = sys.stdin.readline

t = int(input())
ret = []
for k in range(t):
    n, m = map(int, input().rstrip().split()) # n: 문서 개수, m: 문서의 알고자 하는 출력 순서
    w = list(map(int, input().rstrip().split())) # w: 중요도 배열
    p = deque(w)

    task = 0
    while True:
        if p[0] == max(p): # 현재 인쇄해야하는 중요도라면 task + 1
            task += 1
            p.popleft()
            if m == 0:
                ret.append(str(task))
                break
        else: # rotate보다 시간복잡도 유리
            p.append(p.popleft()) # 아니라면 뒤에 다시 추가

        m -= 1  # 인쇄하거나 뒤로돌리거나는 인덱스를 -1 시킨다
        if m < 0: # 0보다 작은경우는 맨 뒤로 간 경우
            m = len(p) - 1
print("\n".join(ret))