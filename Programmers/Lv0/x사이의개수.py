def solution(myString):
    answer = []
    cnt = 0
    for ch in myString:
        if ch == 'x':
            answer.append(cnt)
            cnt = 0
        else:
            cnt += 1
    answer.append(cnt)
    return answer