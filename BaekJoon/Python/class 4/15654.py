# N과 M(5)
from itertools import permutations
n, m = map(int, input().split())

data = list(map(int, input().split()))
data.sort()
combs = list(permutations(data, m))
for _set in combs:
    for _fac in _set:
        print(_fac, end=" ")
    print("")