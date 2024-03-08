def solution(arr, k):
    for idx in range(len(arr)):
        if k % 2 == 1:
            arr[idx] = arr[idx] * k
        else:
            arr[idx] = arr[idx] + k
    return arr