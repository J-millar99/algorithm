def solution(myString):
    answer = ""
    for ch in myString:
        if 'B' <= ch <= 'Z':
            ch = chr(ord(ch) + (ord('a') - ord('A')))
        elif (ch == 'a'):
            ch = chr(ord(ch) - (ord('a') - ord('A')))
        answer += ch
    return answer