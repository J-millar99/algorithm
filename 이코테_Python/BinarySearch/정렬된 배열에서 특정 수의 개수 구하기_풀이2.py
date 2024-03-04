from bisect import bisect_left, bisect_right

N, x = map(int, input().split())
data = list(map(int, input().split()))

result = bisect_right(data, x) - bisect_left(data, x)
if result == 0:
    result = -1
print(result)