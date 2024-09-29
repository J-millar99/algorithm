# 구간 합 구하기 5
import sys
input = sys.stdin.readline

n, m = map(int, input().rstrip().split())
_map = [list(map(int, input().rstrip().split())) for _ in range(n)]
ret = []
for _ in range(m):
    cord = list(map(int, input().rstrip().split()))
    submap = [row[cord[1] - 1:cord[3]] for row in _map[cord[0] - 1:cord[2]]]
    ret.append(str(sum(sum(row) for row in submap)))
print("\n".join(ret))