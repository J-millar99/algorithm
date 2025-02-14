# Four Square
import sys, math
input = sys.stdin.readline
def solution(n):
    sqrt_num = int(math.sqrt(n))
    # 제곱수인 경우 1 반환
    if pow(sqrt_num, 2) == n:
        return 1
    # 두 제곱수의 합으로 표현되는 경우 체크
    for i in range(1, sqrt_num + 1):
        square_i = pow(i, 2)
        if int(math.sqrt(n - square_i)) ** 2 == n - square_i:
            return 2
    # 세 제곱수의 합으로 표현되는 경우 체크
    for i in range(1, sqrt_num + 1):
        square_i = pow(i, 2)
        for j in range(1, int(math.sqrt(n - square_i)) + 1):
            square_j = pow(j, 2)
            if int(math.sqrt(n - square_i - square_j)) ** 2 == n - square_i - square_j:
                return 3
    # 나머지는 모두 4
    return 4
n = int(input())
print(solution(n))
