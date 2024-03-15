def solution(numbers, k):
    cnt = 1
    idx = 0
    while cnt != k:
        idx += 2
        if idx > len(numbers) - 1:
            idx -= len(numbers)
        cnt += 1
    return numbers[idx]