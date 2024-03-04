n = int(input())
t = 0
cnt = 0

while (t < ((n + 1) * 3600) - 1):
    t += 1
    h = t // 3600
    if (h // 10 == 3) or (h % 10 == 3):
        cnt += 1
        continue
    m = t % 3600 // 60
    if (m // 10 == 3) or (m % 10 == 3):
        cnt += 1
        continue
    s = (t % 3600) % 60
    if (s // 10 == 3) or (s % 10 == 3):
        cnt += 1
        continue

print(cnt)