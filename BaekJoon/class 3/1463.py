'''
n = int(input())

count = 0
vals = set()
if n % 3 == 0:
    vals.add(n//3)
if n % 2 == 0:
    vals.add(n//2)
vals.add(n-1)
count = 1

while True:
    ret = set()
    if 1 in vals:
        break
    for v in vals:
        if v % 3 == 0:
            ret.add(v//3)
        if v % 2 == 0:
            ret.add(v//2)
        ret.add(v-1)
    count += 1
    vals = ret

if n == 1:
    print(0)
else:
    print(count)
'''


def _dp(N):
    # DP 테이블 초기화 (최대 N까지)
    dp = [0] * (N + 1)

    for i in range(2, N + 1):
        # 1을 뺀 경우
        dp[i] = dp[i - 1] + 1
        
        # 2로 나누어 떨어질 때
        if i % 2 == 0:
            dp[i] = min(dp[i], dp[i // 2] + 1)
        
        # 3으로 나누어 떨어질 때
        if i % 3 == 0:
            dp[i] = min(dp[i], dp[i // 3] + 1)

    return dp[N]

# 입력 처리
N = int(input())
print(_dp(N))
