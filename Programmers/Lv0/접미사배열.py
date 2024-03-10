def solution(my_string):
    return sorted([my_string[x:] for x in range(len(my_string))])