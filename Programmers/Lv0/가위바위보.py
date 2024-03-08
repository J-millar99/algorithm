def solution(rsp):
    answer = ""
    for ch in rsp:
        if ch == '0':
            answer += "5"
        elif ch == '2':
            answer += "0"
        elif ch == '5':
            answer += "2"
    return answer