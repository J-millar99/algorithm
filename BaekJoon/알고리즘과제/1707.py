# 이분 그래프
from collections import deque
import sys
input = sys.stdin.readline

def get_adjacency_list(v, e):
    adj_list = [[] for _ in range(v)]
    for _ in range(e):
        i, j = map(int, input().rstrip().split())
        adj_list[i - 1].append(j - 1)
        adj_list[j - 1].append(i - 1)
    return adj_list

def check_bipartite(adj_list):
    n = len(adj_list)
    color = [-1] * n  # 색을 저장하는 배열 (-1은 아직 색칠되지 않음을 의미)

    for start in range(n):
        if color[start] == -1:  # 아직 색칠되지 않은 노드에 대해 탐색
            queue = deque([start])
            color[start] = 0  # 시작 노드는 0으로 색칠

            while queue:
                node = queue.popleft()
                
                for neighbor in adj_list[node]:
                    if color[neighbor] == -1:  # 인접 노드가 아직 색칠되지 않았다면
                        color[neighbor] = 1 - color[node]  # 현재 노드와 다른 색으로 색칠
                        queue.append(neighbor)
                    elif color[neighbor] == color[node]:  # 인접 노드가 같은 색이면 이분그래프가 아님
                        return False

    return True

k = int(input())  # 테스트 케이스 수
for _ in range(k):
    v, e = map(int, input().rstrip().split())  # 노드와 간선의 수 입력
    adj_list = get_adjacency_list(v, e)  # 인접 리스트 생성
    print("YES") if check_bipartite(adj_list) else print("NO")
