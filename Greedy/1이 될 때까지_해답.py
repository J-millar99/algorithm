n, k = map(int, input().split())
cnt = 0
while True:
    target = (n // k) * k
    cnt += (n - target)
    n = target
    if n < k:
        break
    n //= k
    cnt += 1
cnt += (n - 1)

print(cnt)