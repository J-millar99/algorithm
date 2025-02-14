# 랜선 자르기
import sys
input = sys.stdin.readline
k, n = map(int, input().rstrip().split())
data = [int(input().rstrip()) for _ in range(k)]
ret = None

# 선형탐색 (시간초과)
# if n == k:
#     ret = min(data)
# else:
#     val = 1
#     while True:
#         count = 0
#         for len in data:
#             count += (len // val)
#         if count >= n:
#             val += 1
#             continue
#         ret = val - 1
#         break

# 이분 탐색
low, high = 1, max(data)
while low <= high:
    mid = (low + high) // 2
    count = sum(len // mid for len in data)
    if count >= n:
        ret = mid
        low = mid + 1
    else:
        high = mid - 1

# 결과 출력
print(ret)