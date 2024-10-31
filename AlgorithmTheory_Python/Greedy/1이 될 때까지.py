n, k = map(int, input().split())
count = 0
# while n != 1:
#     if n % k == 0:
#         n /= k
#     else:
#         n -= 1
#     count += 1
# print(count)

while True:
    mod = (n // k) * k # mod : k로 나누어 떨어지는 수
    count += (n - mod) # 1을 빼줘야 하는 횟수를 계산
    n = mod # 1을 빼는 연산을 수행했으니 남은 수 n을 mod로 초기화
    if n < k: # 나눌 수 없으면
        break
    # 나눌 수 있으면
    n /= k
    count += 1

count += (n - 1) # n < k인 경우에 루프를 빠져나온다. n이 1이 되려면 n - 1만큼 뺄셈 연산을 수행해야 한다
print(count)