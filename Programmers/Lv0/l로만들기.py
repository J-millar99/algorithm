def solution(myString):
    answer = ""
    for ch in myString:
        if ch < 'l':
            ch = 'l'
        answer += ch
    return answer