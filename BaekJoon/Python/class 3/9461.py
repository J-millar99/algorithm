# 파도반 수열
import sys
input = sys.stdin.readline

def func(n):
    dp = [0] * (101)
    dp[1] = 1
    dp[2] = 1
    dp[3] = 1
    for i in range(4, n + 1):
        dp[i] = dp[i - 2] + dp[i - 3]       
    return dp[n]
    

tc = int(input())

for _ in range(tc):
    n = int(input())
    print(func(n))