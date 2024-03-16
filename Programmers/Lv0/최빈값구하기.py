def solution(array):
    dict = {}
    for i in array:
        dict[i] = 0
    for i in array:
        dict[i] += 1
    _max = max(dict.values())
    if list(dict.values()).count(_max) != 1:
        return -1
    max_keys = [key for key, value in dict.items() if value == _max]
    return max_keys[0]