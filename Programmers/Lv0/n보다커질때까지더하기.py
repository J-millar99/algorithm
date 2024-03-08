def solution(numbers, n):
    sum = 0
    for num in numbers:
        if sum <= n:
            sum += num
    return sum