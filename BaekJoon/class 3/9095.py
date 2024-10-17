# 1, 2, 3 더하기

'''
    2 : 1 + 1

    3 : 1 + 1 + 1
        1 + 2         
        2 + 1

    4 : 1 + 1 + 1 + 1
        1 + 1 + 2
        1 + 2 + 1
        2 + 1 + 1
        2 + 2
        1 + 3
        3 + 1

'''

test = int(input())
def _get(n):
    dp = [0 for _ in range(n + 1)]
    if n < 4:
        if n == 3:
            return 4
        return n
    dp[1] = 1
    dp[2] = 2
    dp[3] = 4

    for i in range(4, n + 1):
        dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1]

    return dp[n]


for _ in range(test):
    print(_get(int(input())))