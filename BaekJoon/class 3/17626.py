# Four Squares
import math
n = int(input())
cnt = 0

while n > 0:
    ret = int(math.sqrt(n))
    print(ret)
    ret *= ret
    n -= ret
    cnt += 1

print(cnt)
