def solution(numbers):
    numbers.sort()
    return numbers[len(numbers) - 1] * numbers[len(numbers) - 2]

# 함수 안쓰기
def solution(numbers):
    numbers.sort()
    return numbers[-1] * numbers[-2]