def solution(arr):
    for idx in range(len(arr)):
        num = arr[idx]
        if num >= 50 and num % 2 == 0:
            num = num // 2
        elif num < 50 and num % 2 == 1:
            num = num * 2
        arr[idx] = num
    return arr