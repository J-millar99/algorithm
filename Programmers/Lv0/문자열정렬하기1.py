def solution(my_string):
    return sorted([int(num) for num in my_string if '0' <= num <= '9'])

# sort메서드는 배열을 정렬하고 None을 반환한다.
# sorted함수는 정렬된 배열을 반환한다.