# 이중 우선순위 큐
import sys, heapq
input = sys.stdin.readline

# 최소힙으로 생성
def _insert(val):
    if not val in finder:
        finder[val] = 1
    else:
        finder[val] += 1
    heapq.heappush(minq, val) # 최소힙
    heapq.heappush(maxq, -val) # 최대힙

def _delete(val):
    if val == "1": # 최대값 제거
        while maxq:
            _max = -heapq.heappop(maxq)
            if _max in finder and finder[_max] > 0: # 딕셔너리에 있고 값이 유효하다면 1개 줄이기
                finder[_max] -= 1
                break

    elif val == "-1": # 최소값 제거
        while minq:
            _min = heapq.heappop(minq)
            if _min in finder and finder[_min] > 0:
                finder[_min] -= 1
                break

tc = int(input())
result = []
for _ in range(tc):
    maxq = []
    minq = []
    finder = {}
    opNum = int(input())
    for _ in range(opNum):
        op, val = input().rstrip().split()
        if op == "I":
            _insert(int(val))
        elif op == "D":
            _delete(val)
    ret = [key for key, value in finder.items() if value != 0]
    if not ret:
        result.append("EMPTY")
    else:
        result.append(f"{max(ret)} {min(ret)}")

for r in result:
    print(r)