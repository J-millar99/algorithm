def fact(i):
    if i != 0:
        return i * fact(i - 1)
    return 1

def solution(n):
    i = 1
    while (fact(i) <= n):
        i += 1
    return i - 1