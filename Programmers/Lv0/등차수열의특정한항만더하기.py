def solution(a, d, included):
    answer = 0
    for idx in range(len(included)):
        if included[idx] == True:
            answer += a + d * idx
    return answer