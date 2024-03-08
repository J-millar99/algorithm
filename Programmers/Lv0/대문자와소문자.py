def solution(my_string):
    answer = ""
    for ch in my_string:
        if 'a' <= ch <= 'z':
            answer += chr(ord(ch) - (ord('a') - ord('A')))
        elif 'A' <= ch <= 'Z':
            answer += chr(ord(ch) + (ord('a') - ord('A')))
    return answer