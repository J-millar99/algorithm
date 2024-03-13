def solution(my_string):
    answer = 0
    num = 0
    for ch in my_string:
        if ('0' <= ch <= '9'):
            num *= 10
            num += int(ord(ch) - ord('0'))
        else :
            answer += num
            num = 0
    return answer + num