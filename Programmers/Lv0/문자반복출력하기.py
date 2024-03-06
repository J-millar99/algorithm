def solution(my_string, n):
    answer = ''
    for ch in range(len(my_string)):
        for _ in range(n):
            answer += ch
    return answer

def solution(my_string, n):
    answer = ''
    for i in my_string:
        for _ in range(n):
            answer += i
    return answer

def solution(my_string, n):
    answer = ''
    for i in my_string:
            answer += i * n
    return answer

# 파이썬은 문자열에 곱셈 연산이 된다
# join은 c언어의 strjoin함수와 동일하다
def solution(my_string, n):
    return ''.join(i*n for i in my_string)