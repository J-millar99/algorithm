def solution(i, j, k):
    my_dict = {}
    for _ in range(10):
        my_dict[_] = 0
    for x in range(i, j + 1):
        for charNum in str(x):
            my_dict[int(charNum)] += 1
    return my_dict[k]