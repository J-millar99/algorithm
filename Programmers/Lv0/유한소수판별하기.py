def gcd(a, b):
    while b > 0:
        a, b = b, a % b
    return a

def solution(a, b):
    den = b / gcd(a, b)
    while den != 1:
        if den % 2 == 0:
            den //= 2
        if den % 5 == 0:
            den //= 5
        if den == 1:
            return 1
        if den % 2 != 0 and den % 5 != 0:
            return 2
    return 1