def solution(str1, str2):
    return 1 if str1.find(str2) != -1 else 2

#   다음과 같은 문법도 가능하다
def solution(str1, str2):
    return 1 if str2 in str1 else 2