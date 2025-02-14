# 타임머신
import sys
input = sys.stdin.readline

v, e = map(int, input().split())
INF = float('inf')
dist = [INF] * (v + 1)
dist[1] = 0

edges = []

for _ in range(e):
    a, b, c = map(int, input().split())
    edges.append((a, b, c))

for _ in range(v - 1):
    for a, b, c in edges:
        if dist[a] != INF and dist[a] + c < dist[b]:
            dist[b] = dist[a] + c

has_negative_cycle = False
for a, b, c in edges:
    if dist[a] != INF and dist[a] + c < dist[b]:
        has_negative_cycle = True
        break

if has_negative_cycle:
    sys.stdout.write("-1\n")
else:
    for dest in range(2, v + 1):
        if dist[dest] == INF:
            sys.stdout.write("-1\n")
        else:
            sys.stdout.write(str(dist[dest]) + "\n")
