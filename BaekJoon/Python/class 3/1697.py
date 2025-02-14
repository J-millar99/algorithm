from collections import deque
n, k = map(int, input().split())
memo = set()
def bfs(start, time):
    q = deque([(start, time)])
    ret = 0 # 찾은 시간
    memo.add(start)
    while q:
        v, t = q.popleft()
        ret = t
        if v == k:
            return ret
        if v * 2 < 100001 and v * 2 not in memo:
            q.append((v * 2, t + 1))
            memo.add(v * 2)
        if v + 1 < 100001 and v + 1 not in memo:
            q.append((v + 1, t + 1))
            memo.add(v + 1)
        if v - 1 >= 0 and v - 1 not in memo:
            q.append((v - 1, t + 1))
            memo.add(v - 1)

print(bfs(n, 0))
            