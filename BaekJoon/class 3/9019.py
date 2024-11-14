# DSLR
import sys
input = sys.stdin.readline
# D : n을 두배로 바꾼다. 9999보다 큰 경우에는 10000으로 나눈 나머지
# S : n에서 1을 뺀 결과 n - 1을 레지스터에 저장 n이 0이라면 9999저장
# L : n의 각 자릿수를 왼편으로 회전시켜 저장
# R : 오른쪽으로 회전시킴

for _ in range(int(input())):
    srcs, dest = input().rstrip.split()
    