def solution(arr):
    i = 1
    if len(arr) == 1:
        return arr
    while len(arr) > pow(2, i):
        i += 1
    while len(arr) < pow(2, i):
        arr.append(0)
    return arr