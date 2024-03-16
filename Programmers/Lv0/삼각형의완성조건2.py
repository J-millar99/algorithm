def solution(sides):
    _set = set()
    for i in range(max(sides) - min(sides) + 1, max(sides) + 1):
        _set.add(i)
    for j in range(max(sides) + 1, max(sides) + min(sides)):
        _set.add(j)
    return len(_set)
