# 계단 오르기
import sys
input = sys.stdin.readline
n = int(input())
stair = []

for _ in range(n):
    stair.append(int(input()))

def _dp():
    dp = [0] * (301)
    dp[1] = stair[0]
    dp[2] = stair[0] + stair[1]

    for i in range(3, n + 1):
        dp[i] = max(dp[i - 2], stair[i - 2] + dp[i - 3])
        dp[i] += stair[i - 1]    
    print(dp[n])

if n < 3:
    print(sum(stair))
else:
    _dp()