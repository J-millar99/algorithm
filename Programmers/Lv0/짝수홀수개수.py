def solution(num_list):
    even = 0
    odd = 0
    answer = []
    for num in num_list:
        if (num % 2 == 1):
            odd += 1
        else:
            even += 1
    answer.append(even)
    answer.append(odd)
    return answer

# 짝수자리에 짝수 넣고, 홀수자리에 홀수 넣는 방법
def solution(num_list):
    answer = [0,0]
    for n in num_list:
        answer[n%2]+=1
    return answer