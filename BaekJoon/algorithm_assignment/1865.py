# 웜홀
import sys
input = sys.stdin.readline
INF = float('inf')

def connect():
    edges = []
    # 도로 정보 (양방향 연결)
    for _ in range(m):
        s, e, t = map(int, input().split())
        edges.append((s, e, t))
        edges.append((e, s, t))  # 양방향이므로 반대 방향도 추가

    # 웜홀 정보 (단방향 연결)
    for _ in range(w):
        s, e, t = map(int, input().split())
        edges.append((s, e, -t))  # 웜홀은 단방향이고 가중치가 음수임
    return edges

def has_negative_cycle(n, edges):
    dist = [INF] * (n + 1)
    dist[0] = 0  # 가상의 노드(0번 노드)를 시작점으로 설정

    # 가상의 노드에서 모든 실제 노드로 가는 간선 추가
    for i in range(1, n + 1):
        edges.append((0, i, 0))
    # (n - 1)번 반복하며 모든 간선을 확인
    for _ in range(n):
        for u, v, weight in edges:
            if dist[u] != INF and dist[u] + weight < dist[v]:
                dist[v] = dist[u] + weight

    # 음수 사이클 확인: 마지막 반복에서도 거리가 갱신되면 음수 사이클이 있음
    for u, v, weight in edges:
        if dist[u] != INF and dist[u] + weight < dist[v]:
            return True  # 음수 사이클 발견

    return False

tc = int(input())
for _ in range(tc):
    n, m, w = map(int, input().split())
    route = connect()
    if has_negative_cycle(n, route):
        print("YES")
    else:
        print("NO")
    
