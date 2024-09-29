# Z

# 입력 선언
import sys, math
input = sys.stdin.readline

# 입력 받기
size, r, c = map(int, input().rstrip().split())
Z = 0

def _divide(size):
    global Z
    if size == 2:
        return
    else:
        size //= 2
        _divide(size)

_divide(2 ** size)
print(Z)