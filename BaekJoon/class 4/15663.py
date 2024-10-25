# N과 M(9)
from itertools import permutations
n, m = map(int, input().split())

data = list(map(int, input().split()))
data.sort()
combs = list(permutations(data, m))
unique_combs = list(dict.fromkeys(combs))

for _set in unique_combs:
    for _fac in _set:
        print(_fac, end=" ")
    print("")