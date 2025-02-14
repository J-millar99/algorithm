# 보석 도둑
import sys, heapq
input = sys.stdin.readline

# n:보석 개수, k: 가방 개수
n, k = map(int, input().split())
jew = []
bag = []

# 보석 입력받기
for _ in range(n):
    # 무게와 가치
    m, v = map(int, input().split())
    jew.append([m, v])
jew.sort()

# 가방 입력받기
for _ in range(k):
    bag.append(int(input()))
bag.sort()

# 가방에 들어갈 수 있는 보석들을 선택
choice = []
ret = 0
i = 0

# 작은 가방부터 하나 선택
for b in bag:
    # 가방에 들어갈 수 있는 보석들을 가치를 기준으로 최대힙 구성
    while i < n and jew[i][0] <= b:
        heapq.heappush(choice, -jew[i][1])
        i += 1
    # 해당 가방에 들어갈 수 있는 보석중 가장 값이 높은 보석을 더함
    if choice:
        ret += -heapq.heappop(choice)

print(ret)