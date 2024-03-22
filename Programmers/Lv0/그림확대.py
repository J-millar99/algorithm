def solution(picture, k):
    answer = []
    for str in picture:
        retStr = ''.join([char * k for char in str])
        for _ in range(k):
            answer.append(retStr)
    return answer