# 파이썬의 문자열은 이뮤터블(immutable) 데이터 타입이다.
def solution(my_string, num1, num2):
    lst = list(my_string)
    tmp = lst[num1]
    lst[num1] = lst[num2]
    lst[num2] = tmp
    return ''.join(lst)