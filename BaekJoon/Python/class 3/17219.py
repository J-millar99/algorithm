# 비밀번호 찾기
import sys
input = sys.stdin.readline
n, m = map(int, input().rstrip().split())
dic = {}
for _ in range(n):
    site, pw = input().rstrip().split()
    dic[site] = pw

for _ in range(m):
    print(dic[input().rstrip()])