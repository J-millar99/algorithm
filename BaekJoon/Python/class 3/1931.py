# 회의실 배정
import sys

input = sys.stdin.readline
n = int(input())
pq = []
for _ in range(n):
    s, t = map(int, input().rstrip().split())
    pq.append((s, t))
pq.sort(key=lambda x: (x[1], x[0]))
count = 0
endtime = 0
for s, t in pq:
    if s >= endtime:
        count +=1
        endtime = t
print(count)
# 하나의 강의실에 최대한 들어갈 수 있는 수업을 결정하는 것이므로
# 강의가 끝나는 시간을 오름차순으로 배열한 뒤, 강의가 끝나는 시간과 다음 강의가 시작하는 시간을 이어붙인다.
# 강의가 끝나는 시간이 같다면 시작시간이 이른것이 먼저 와야함