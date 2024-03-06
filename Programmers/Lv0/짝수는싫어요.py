def solution(n):
    list = []
    for i in range(1, n + 1):
        if i % 2 == 1:
            list.append(i)
    return list

# 조건문과 반복문을 한 줄에 명시하는 방법
def solution(n):
    return [x for x in range(n + 1) if x % 2]