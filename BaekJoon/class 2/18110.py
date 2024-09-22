# solved.ac
import sys
'''
    1. 의견 없음 => 0난이도
    2. 의견 있음 => 절사평균 30%

    절사평균 : 상위 15%, 하위 15%를 반올림하여 제거

    계산된 평균도 반올림
'''

def myround(x):
    if (x - int(x)) >= 0.5:
        return int(x) + 1
    else:
        return int(x)

input = sys.stdin.readline
n = int(input())
data = []

for _ in range(n):
    data.append(int(input()))

if n == 0:
    print(0)
else:
    cut = myround(n * 0.15)
    data.sort()
    print(myround(sum(data[cut:n - cut]) / (n - (cut * 2))))