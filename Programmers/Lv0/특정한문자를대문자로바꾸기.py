def solution(my_string, alp):
    answer = ""
    for ch in my_string:
        if ch == alp:
            answer += chr(ord(ch) - (ord('a') - ord('A')))
        else:
            answer += ch
    return answer