'''
    위상 정렬은 순서가 정해져 있는 이련의 작업을 차례대로 수행해야 할 때 사용할 수 있는 알고리즘
    방향 그래프의 모든 노드를 '방향성에 거스르지 않도록 순서대러 나열하는 것'
    
    1. 진입차수가 0인 노드를 큐에 넣는다
    2. 큐가 빌 때 까지 다음의 과정을 반복한다
        a. 큐에서 원소를 꺼내 해당 노드에서 출발하는 간선을 그래프에서 제거한다
        b. 새롭게 진입차수가 0이 된 노드를 큐에 넣는다
    
    * 모든 원소를 방문하기 전에 큐가 빈다면 사이클이 존재한다고 판단
    O(V + E)
'''

from collections import deque

# 노드의 개수와 간선의 개수를 입력받기
v, e = map(int, input().split())
# 모든 노드에 대한 진입차수는 0으로 초기화
indegree = [0] * (v + 1)
# 각 노드에 연결된 간선 정보를 담기 위한 연결 리스트 초기화
graph = [[] for i in range(v + 1)]
result = [] # 알고리즘 수행 결과를 담을 리스트

# 방향 그래프의 모든 간선 정보를 입력받기
for _ in range(e):
    a, b = map(int, input().split())
    graph[a].append(b) # 정점 a에서 b로 이동
    # 진입차수를 1 증가
    indegree[b] += 1

# 위상 정렬 함수
def topology_sort():
    q = deque() # 큐 기능을 위한 deque 라이브러리 사용
    # 처음 시작할 때는 진입차수가 0인 노드를 큐에 삽입
    for i in range(1, v + 1):
        if indegree[i] == 0:
            q.append(i)

    # 큐가 빌 때까지 반복
    while q:
        # 큐에서 원소 꺼내기
        now = q.popleft()
        result.append(now)
        # 해당 원소와 연결된 노드들의 진입차수에서 1 빼기
        for i in graph[now]:
            indegree[i] -= 1
            # 새롭게 진입차수가 0이 되는 노드를 큐에 삽입
            if indegree[i] == 0:
                q.append(i)
                
for i in result:
    print(i, end=' ')

topology_sort()
    