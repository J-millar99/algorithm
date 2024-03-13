def solution(s):
    answer = ''
    dict = {}
    for ch in s:
        if ch in dict:
            dict[ch] += 1
        else :
            dict[ch] = 1
    for key in dict:
        if dict[key] == 1:
            answer += key
    return ''.join(sorted(answer))