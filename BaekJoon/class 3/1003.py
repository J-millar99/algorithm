# 피보나치 함수

def fibonacci(num):
    if num == 0:
        count0 += 1
        return 0
    elif num == 1:
        count1 += 1
        return 1
    return fibonacci(num - 1) + fibonacci(num - 2)
    

import sys
input = sys.stdin.readline
n = int(input())
for _ in range(n):
    num = int(input())
    count0 = 0
    count1 = 0
    fibonacci(num)
    print(count0, count1, sep=" ")