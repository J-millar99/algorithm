n = int(input())
store = list(map(int, input().split()))

dp = [0] * (n + 1)
dp[1] = store[0]
dp[2] = max(store[0], store[1])

# 4
# store      [10, 1, 1, 6] (4)
# dp        0[10, 10, 11, 16] (5)

for i in range(3, n + 1):
    dp[i] = max(dp[i - 1], dp[i - 2] + store[i - 1])

print(dp[i])