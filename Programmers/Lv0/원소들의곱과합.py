def solution(num_list):
    sumPow = 0
    mulply = 1
    for num in num_list:
        sumPow += num
        mulply *= num
    return 1 if mulply < sumPow ** 2 else 0