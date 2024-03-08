def solution(num_list):
    if len(num_list) > 10:
        answer = 0
        for num in num_list:
            answer += num
        return answer
    else:
        answer = 1
        for num in num_list:
            answer *= num
        return answer