def solution(numbers):
    answer = -10000 * 10000
    for i in range(len(numbers) - 1):
        for j in range(i + 1, len(numbers)):
            if answer < numbers[i] * numbers[j]:
                answer = numbers[i] * numbers[j]
    return answer