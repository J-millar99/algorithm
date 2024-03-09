def solution(str_list, ex):
    answer = ""
    for str in str_list:
        if not ex in str:
            answer += str
    return answer