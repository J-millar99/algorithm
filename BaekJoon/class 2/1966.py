# 프린터 큐
import sys
from collections import deque
input = sys.stdin.readline

t = int(input())
ret = []
for _ in range(t):
    n, m = map(int, input().rstrip().split()) # n: 문서 개수, m: 문서의 알고자 하는 출력 순서
    weight = list(map(int, input().rstrip().split())) # w: 중요도 배열
    p = deque(weight)

task = 0
r_count = 0
for i in range(9, 0, -1):
    sheet = p.popleft() # 일단 문서를 확인
    if sheet == i: # 현재 인쇄해야하는 중요도라면 task + 1
        task += 1
    else:
        p.append(sheet) # 아니라면 뒤에 추가
    m -= 1  # 인쇄하거나 뒤로돌리거나는 인덱스를 -1 시킨다
    if m < 0: # 0보다 작은경우는 맨 뒤로 간 경우
        m = len(p) - 1
    if len(p) == 0: # 출력할 것이 없으면 멈춘다
        break

print(task)