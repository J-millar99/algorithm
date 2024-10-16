# 절댓값 힙
import sys, heapq
input = sys.stdin.readline
pq = [] # 양수 큐
nq = [] # 음수 큐

data = []
for _ in range(int(input())):
    n = int(input())
    if n > 0:
        heapq.heappush(pq, n) # 작은 수로 정렬
    elif n < 0:
        heapq.heappush(nq, n * -1) # 음수이므로 큰 수로 정렬
    
    else:
        if not pq and not nq: # 힙이 둘다 비어있다면 0출력
            # print(0)
            data.append(0)
        else:
            if not pq:
                data.append(-heapq.heappop(nq))
            elif not nq:
                data.append(heapq.heappop(pq))
            elif abs(pq[0]) < abs(nq[0] * -1):
                data.append(heapq.heappop(pq))
            else:
                data.append(-heapq.heappop(nq))

for d in data:
    print(d)