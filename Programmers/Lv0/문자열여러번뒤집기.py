def solution(my_string, queries):
    for querie in queries:
        my_string = my_string[:querie[0]] + (my_string[querie[0]:querie[1] + 1])[::-1] + my_string[querie[1] + 1:]
    return my_string
