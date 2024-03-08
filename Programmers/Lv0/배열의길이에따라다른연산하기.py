def solution(arr, n):
    length = len(arr)
    if length % 2 == 0:
        for idx in range(1, length, 2):
            arr[idx] += n
    else:
        for idx in range(0, length, 2):
            arr[idx] += n
    return arr