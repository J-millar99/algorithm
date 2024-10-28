'''
    스패닝 트리 : 하나의 그래프가 있을 때 모든 노드를 포함하면서 사이클이 존재하지 않는 부분 그래프
    
    크루스칼 알고리즘 : 최소한의 비용으로 신장트리를 구성하는 알고리즘
    1. 간선 데이터를 비용에 따라 오름차순으로 정렬한다
    2. 간선을 하나씩 확인하며 현재의 간선이 사이클을 발생시키는지 확인한다
        a. 사이클이 발생하지 않는 경우 최소 신장 트리에 포함시킨다
        b. 사이클이 발생하는 경우 최소 신장 트리에 포함시키지 않는다
    3. 모든 간선에 대하여 2번의 과정을 반복한다.
    
    O(ElogE)
'''

def find_root(parent, x):
    if parent[x] != x:
        parent[x] = find_root(parent, parent[x])
    return parent[x]

def union_parent(parent, a, b):
    a = find_root(parent, a)
    b = find_root(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

# 노드의 개수와 간선의 개수 입력받기
v, e = map(int, input().split())
parent = [0] * (v + 1)

# 모든 간선을 담을 리스트와 최종 비용을 담을 변수
edges = []
result = 0

for i in range(1, v + 1):
    parent[i] = i

for _ in range(e):
    a, b, cost = map(int, input().split())
    # 비용순으로 정렬하기 위해서 튜플의 첫 번째 원소를 비용으로 설정
    edges.append((cost, a, b))

# 간선을 비용순으로 오름차순 정렬
edges.sort()

# 간선을 하나씩 확인하며
for edge in edges:
    cost, a, b = edge
    # 사이클이 발생하지 않는 경우에만 집합에 포함
    if find_root(parent, a) != find_root(parent, b):
        union_parent(parent, a, b)
        result += cost

print(result)