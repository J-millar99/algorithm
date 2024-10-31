# 이중 우선순위 큐
import sys, heapq
input = sys.stdin.readline

# 최소힙으로 생성
def _insert(val):
    heapq.heappush(minq, val) # 최소힙
    heapq.heappush(maxq, -val) # 최대힙
    finder.add(val)

def _delete(val):
    if val == "1": # 최대값 제거
        while maxq:
            _max = -heapq.heappop(maxq)
            if _max in finder:
                finder.remove(_max)
                break
    elif val == "-1": # 최소값 제거
        while minq:
            _min = heapq.heappop(minq)
            if _min in finder:
                finder.remove(_min)
                break
def getMin():
    while minq:
        _min = minq[0]
        if _min in finder:
            return _min
        heapq.heappop(minq)
    return None

def getMax():
    while maxq:
        _max = -maxq[0]
        if _max in finder:
            return _max
        heapq.heappop(maxq)
    return None

tc = int(input())
result = []
for _ in range(tc):
    maxq = []
    minq = []
    finder = set()
    opNum = int(input())
    for _ in range(opNum):
        op, val = input().rstrip().split()
        if op == "I":
            _insert(int(val))
        elif op == "D":
            _delete(val)
    if not finder:
        result.append("EMPTY")
    else:
        result.append(f"{getMax()} {getMin()}")

for r in result:
    print(r)