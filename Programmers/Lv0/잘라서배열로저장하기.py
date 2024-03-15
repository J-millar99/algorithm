def solution(my_str, n):
    answer = []
    start_idx = 0
    end_idx = n
    while True:
        if len(my_str) <= end_idx:
            break
        else:
            answer.append(my_str[start_idx:end_idx])
            start_idx += n
            end_idx += n
    answer.append(my_str[start_idx:])
    return answer
