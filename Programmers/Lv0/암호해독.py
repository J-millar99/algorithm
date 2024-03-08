def solution(cipher, code):
    answer = ""
    for idx in range(code - 1, len(cipher), code):
        answer += cipher[idx]
    return answer