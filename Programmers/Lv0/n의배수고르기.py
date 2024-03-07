# 리스트 컴프리헨션
def solution(n, numlist):
    answer = [num for num in numlist if num % n == 0]
    return answer