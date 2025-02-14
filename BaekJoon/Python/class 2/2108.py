# 통계학
'''
    산술평균 : N개의 수들의 합을 N으로 나눈 값
    중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
    최빈값 : N개의 수들 중 가장 많이 나타나는 값
    범위 : N개의 수들 중 최댓값과 최솟값의 차
'''
from collections import Counter
import sys
input = sys.stdin.readline
def myround(x):
    if x > 0:
        if (x - int(x)) >= 0.5:
            return int(x) + 1
        else:
            return int(x)
    else:
        if (x - int(x)) <= -0.5:
            return int(x) - 1 
        else:
            return int(x)

n = int(input())
data = [int(input()) for _ in range(n)]
data.sort()
counter = Counter(data)

print(myround(sum(data) / n))
print(data[int(n//2)])
if len(data) != 1:  # 최빈값이 중복일 수 있다면
    t = counter.most_common(2) # 튜플 반환
    if t[0][1] == t[1][1]:  # 최빈값이 중복이라면
        print(t[1][0])      # 두 번째로 작은 값 반환
    else:                   # 최빈값이 중복이 아니라면
        print(t[0][0])
else: # 중복이 아니라면
    print(data[0])
print(data[n - 1] - data[0])
