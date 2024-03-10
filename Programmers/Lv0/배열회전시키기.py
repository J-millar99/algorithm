def solution(numbers, direction):
    if direction == "right":
        numbers.insert(0, numbers[len(numbers) - 1])
        numbers.pop()
    else:
        numbers.append(numbers[0])
        numbers.pop(0)
    return numbers

# list슬라이싱
def solution(numbers, direction):
    return [numbers[-1]] + numbers[:-1] if direction == 'right' else numbers[1:] + [numbers[0]]