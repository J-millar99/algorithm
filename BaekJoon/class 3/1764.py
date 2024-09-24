# 듣보잡
import sys
input = sys.stdin.readline
n, m = map(int, input().rstrip().split())

dic = {}
for _ in range(n):
    name = input().rstrip()
    dic[name] = 1

for _ in range(m):
    name = input().rstrip()
    if name in dic:
        dic[name] += 1

for name in list(dic.keys()):
    if dic[name] == 1:
        del dic[name]

ret = list(dic.keys())
ret.sort()
print(len(ret))
print("\n".join(ret))