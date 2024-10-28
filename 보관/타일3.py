import sys
input = sys.stdin.readline

def dp_func(n):
    for i in range(3, n + 1):
        dp[i] = (dp[i - 2] * 4 + dp[i - 1] * 2) % 1000000007

dp = [0] * 1000001
dp[0] = 1
dp[1] = 2
dp[2] = 7
n = int(input())
dp_func(n)

print(dp[n])
