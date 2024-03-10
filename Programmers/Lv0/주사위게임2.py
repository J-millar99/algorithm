def solution(a, b, c):
    if (a == b and b == c):
        return (3 * a) * (3 * pow(a, 2)) * (3 * pow(a, 3))
    elif (a != b and b != c and a != c):
        return a + b + c
    else:
        return (a + b + c) * (pow(a, 2) + pow(b, 2) + pow(c, 2))
    
# 중복을 허용하지 않는 set의 특징을 이용한 방법
def solution(a, b, c):
    check = len(set([a, b, c]))
    if check == 1:
        return 3*a*3*(a**2)*3*(a**3)
    elif check == 2:
        return (a+b+c)*(a**2+b**2+c**2)
    else:
        return (a+b+c)