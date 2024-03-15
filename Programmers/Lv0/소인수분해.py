def solution(n):
    _set = set()
    while n != 1:
        for div in range(2, n + 1):
            if n % div == 0:
                n //= div
                _set.add(div)
                break
    return sorted(list(_set))
