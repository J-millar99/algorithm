def solution(a, b):
    num1 = str(a) + str(b)
    num2 = 2 * int(a) * int(b)
    return int(num1) if int(num1) >= int(num2) else int(num2)