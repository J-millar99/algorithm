'''
    덮개
        1. 1 x 2
        2. 2 x 1
        3. 2 x 2
    가로 N, 세로 2 고정
'''

n = int(input())
dp = [0] * (n + 1)
dp[1] = 1
dp[2] = 3

for i in range(3, n + 1):
    dp[i] = (dp[i - 1] * 2 + dp[i - 2]) % 796,796

print(dp[i])
