import sys
input = sys.stdin.readline

def find(parent, x):
    if parent[x] != x:
        parent[x] = find(parent, parent[x])
    return parent[x]

def union(parent, a, b):
    a = find(parent, a)
    b = find(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b
                
n, m = map(int, input().split())
parent = [0] * (n + 1)
for i in range(1, n + 1):
    parent[i] = i

for _ in range(m):
    cmd, a, b = map(int, input().split())
    if cmd == 0:
        union(parent, a, b)
    elif cmd == 1 and find(parent, a) == find(parent, b):
        print("YES")
    else:
        print("NO")
        