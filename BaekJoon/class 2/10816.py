# 숫자 카드 2
from collections import Counter

N = int(input())
Ndata = list(map(int, input().split()))

M = int(input())
Mdata = list(map(int, input().split()))

count_dict = Counter(Ndata)

ret = [str(count_dict[m]) for m in Mdata]

print(" ".join(ret))