def solution(balls, share):
    num = 1
    den = 1
    for i in range(2, balls + 1):
        num *= i
    for j in range(2, balls - share + 1):
        den *= j
    for k in range(2, share + 1):
        den *= k
    return num / den