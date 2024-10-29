# 계단 오르기
import sys
input = sys.stdin.readline
n = int(input())
stair = []
for _ in range(n):
    stair.append(int(input()))

dp = [0] * (301)
dp[1] = stair[0]
dp[2] = stair[0] + stair[1]
dp[3] = max(stair[0], stair[1]) + stair[2]

for i in range(4, n + 1):
    dp[i] = max(stair[i - 1] + dp[i - 2], dp[i - 1])
    
print(dp[n])