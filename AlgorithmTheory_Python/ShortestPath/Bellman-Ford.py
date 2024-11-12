import sys
input = sys.stdin.readline
INF = int(1e9)

# 노드의 개수, 간선의 개수 입력받기
n, m = map(int, input().split())
start = int(input())  # 시작 노드 번호 입력받기
edges = []  # 간선 정보를 저장할 리스트
distance = [INF] * (n + 1)  # 최단 거리 테이블을 무한으로 초기화

for _ in range(m):
    a, b, c = map(int, input().split())
    edges.append((a, b, c))  # a -> b의 가중치가 c인 간선 추가

def bellman_ford(start):
    distance[start] = 0
    # N-1번 반복하여 모든 간선 검사
    for i in range(n - 1):
        for u, v, w in edges:
            if distance[u] != INF and distance[u] + w < distance[v]:
                distance[v] = distance[u] + w

    # 음수 사이클 존재 확인
    for u, v, w in edges:
        if distance[u] != INF and distance[u] + w < distance[v]:
            print("음수 가중치 사이클이 존재합니다.")
            return None
    return distance

# 결과 출력
result = bellman_ford(start)
if result:
    for i in range(1, n + 1):
        # 도달할 수 없는 경우 INF 출력
        if distance[i] == INF:
            print("INF")
        else:
            print(distance[i])
