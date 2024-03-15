def solution(q, r, code):
    answer = ''
    for idx in range(len(code)):
        if idx % q == r:
            answer += code[idx]
    return answer