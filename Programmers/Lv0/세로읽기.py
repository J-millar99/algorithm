def solution(my_string, m, c):
    answer = ""
    i = 0
    while (i * m + c - 1 < len(my_string)):
        answer += my_string[i * m + c - 1]
        i += 1
    return answer