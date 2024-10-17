# 패션왕 신혜빈
import sys, itertools, operator
input = sys.stdin.readline
test = int(input())

def calCombination(cs):
    ret = 1
    if len(cs) == 1:
        return cs[0] - 1
    else:
        for c in cs:
            ret *= c
        return ret -1

for _ in range(test):
    wear = int(input())
    cs = {}
    for _ in range(wear):
        n, c  = input().rstrip().split()
        if c in cs:
            cs[c] += 1
        else:
            cs[c] = 2
    print(calCombination(list(cs.values())))