def solution(my_string):
    answer = [0] * 52
    for ch in my_string:
        if 'a' <= ch <= 'z':
            answer[(ord(ch) - ord('a')) + 26] += 1
        else:
            answer[ord(ch) - ord('A')] += 1
    return answer