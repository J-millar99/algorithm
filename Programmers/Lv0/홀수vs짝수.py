def solution(num_list):
    return sum(num_list[0::2]) if sum(num_list[0::2]) > sum(num_list[1::2]) else sum(num_list[1::2])

def solution(num_list):
    return max(sum(num_list[0::2]), sum(num_list[1::2]))