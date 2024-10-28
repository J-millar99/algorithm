n, m = map(int, input().split())

coins = []
for _ in range(n):
    coins.append(int(input()))

dp = [10001] * (101)

for coin in coins:
    dp[coin] = 1
    
for i in range(1, m + 1):
    for coin in coins:
        if i - coin > -1:
            dp[i] = min(dp[i], dp[i - coin] + 1)

print(dp[m]) if dp[m] != 10001 else print(-1)