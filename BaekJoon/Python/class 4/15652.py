# N과 M(4)
from itertools import combinations_with_replacement
n, m = map(int, input().split())

data = [i for i in range(1, n + 1)]

combs = list(combinations_with_replacement(data, m))

for _set in combs:
    for _fac in _set:
        print(_fac, end=" ")
    print("")