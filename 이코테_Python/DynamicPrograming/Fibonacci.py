dp = [0] * 100
def Recursive_fibonacci(n):
    if n <= 1:
        return n
    else:
        return Recursive_fibonacci(n - 1) + Recursive_fibonacci(n - 2)

# 보텀업 방식
def Iterative_fibonacci(n):
    if n <= 1:
        return n
    else:
        a, b = 0, 1
        for _ in range(n - 1):
            a, b = b, a + b
        return b

# 탑다운 방식
def Memoization_fibonacci(n):
    if n <= 1:
        return n
    if dp[n] != 0:
        return dp[n]
    dp[n] = Memoization_fibonacci(n - 1) + Memoization_fibonacci(n - 2)
    return dp[n]