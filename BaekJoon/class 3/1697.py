# 숨바꼭질
from collections import deque
n, k = map(int, input().split())
memo = set()
def bfs(start, time):
    q = deque([(start, time)])
    ret = 0 # 찾은 시간
    while q:
        v, t = q.popleft()
        memo.add((v, t))
        ret = t
        if v == k:
            return ret
        if (v, t) not in memo:
            q.append((v * 2, t + 1))
            q.append((v + 1, t + 1))
            q.append((v - 1, t + 1))
    return ret
print(bfs(n, 0))
            