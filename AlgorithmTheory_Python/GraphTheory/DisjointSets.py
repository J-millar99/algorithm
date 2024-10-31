'''
    서로소 집합이란 공통 원소가 없는 두 집합을 의미한다. 예를 들어 집합 {1, 2}와 집합 {3, 4}는 서로소 관계이다.
    반면에 집합 {1, 2}와 집합 {2, 3}은 2라는 원소가 두 집합에 공통적으로 포함되어 있기 때문에 서로소 관계가 아니다.
    
    서로소 집합 자료구조란 서로소 부분 집합들로 나누어진 원소들의 데이터를 처리하기 위한 자료구조
    서로서 집합 자료구조는 union과 find 2개의 연산으로 조작할 수 있다.
    
    union : 2개의 원소가 포함된 집합을 하나의 집합으로 합치는 연산
    find : 특정한 원소가 속한 집합이 어떤 집합인지 알려주는 연산
    
    트리를 이용한 서로소 집합 계산 알고리즘
    1. union 연산을 확인하여, 서로 연결된 두 노드 A, B를 확인한다
        a. A와 B의 루트 노드 A', B'를 각각 찾는다
        b. A'를 B'의 부모 노드로 설정한다(B'가 A'를 가리키도록 한다)
    2. 모든 union 연산을 처리할 때까지 1번 과정을 반복한다
    O(V + M(1 + log_(2-M/V) V))
'''

# 특정 원소가 속한 집합을 찾기
def find_parent(parent, x):
    # 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
    if parent[x] != x:
        return find_parent(parent, parent[x])
    return x

# 특정 원소가 속한 루트를 찾기
def find_root(parent, x):
    if parent[x] != x:
        parent[x] = find_root(parent, parent[x])
    return parent[x]

# 두 원소가 속한 집합을 합치기 : 노드 번호가 작은 것이 루트가 됨
def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

# 노드의 개수와 간선(union 연산)의 개수 입력받기
v, e = map(int, input().split())
parent = [0] * (v + 1) # 부모 테이블 초기화

# 부모 테이블상에서, 부모를 자기 자신으로 초기화
for i in range(1, v + 1):
    parent[i] = i

# union 연산을 각각 수행
for i in range(e):
    a, b = map(int, input().split())
    union_parent(parent, a, b)

print('각 원소가 속한 집합: ', end='')
for i in range(1, v + 1):
    print(find_parent(parent, i), end=' ')

print()

# 부모 테이블 내용 출력
print('부모 테이블: ', end='')
for i in range(1, v + 1):
    print(parent[i], end=' ')