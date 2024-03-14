def solution(arr):
    if arr.count(2) == 0:
        return [-1]
    elif arr.count(2) == 1:
        return [2]
    else:
        return arr[arr.index(2):len(arr) - arr[::-1].index(2)]