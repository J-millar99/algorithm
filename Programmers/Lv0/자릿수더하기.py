def solution(n):
    answer = 0
    n = str(n)
    for i in range(len(n)):
        answer += int(n[i])
    return answer

# map을통해 문자열을 정수로 바꾸어 리스트화 하고 자릿수를 더하는 방법
def solution(n):
    answer = sum(list(map(int,str(n))))
    return answer