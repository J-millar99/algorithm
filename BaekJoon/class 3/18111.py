# 마인크래프트
import sys
input = sys.stdin.readline
n, m, b = map(int, input().split())

time = 0
graph = {}
for _ in range(n):
    line = list(map(int, input().split()))
    for l in line:
        if l in graph:
            graph[l] += 1
        else:
            graph[l] = 1
def check():
    floor = graph.keys()
    top = max(floor)
    bottom = min(floor)
    return top, bottom
    
while len(graph) != 1:
    # 현재 상태 확인
    top, bottom = check()
    # 시간이 더 적게 드는 방법을 택함 쌓는 시간과 파는 시간이 동일하다면 최대 높이를 만드는 쌓기를 택함
    if graph[top] * 2 >= graph[bottom]:
        # 쌓는게 가능하다면
        if b >= graph[bottom]:
            if bottom + 1 in graph:
                graph[bottom + 1] += graph[bottom]
            else:
                graph[bottom + 1] = graph[bottom]
            # 쌓은만큼 블럭 감소
            b -= graph[bottom]
            # 시간 누적
            time += graph[bottom]
            # 최하단 층 갱신
            del graph[bottom]
        else:
            # 불가능하면 파기
            if top - 1 in graph:
                graph[top - 1] += graph[top]
            else:
                graph[top - 1] = graph[top]
            # 판 만큼 블럭 추가
            b += graph[top]
            # 시간 누적
            time += (graph[top] * 2)
            # 최상단 층 갱신
            del graph[top]
            # 파는게 빠르다면
    else:
        # 불가능하면 파기
        if top - 1 in graph:
            graph[top - 1] += graph[top]
        else:
            graph[top - 1] = graph[top]
        # 판 만큼 블럭 추가
        b += graph[top]
        # 시간 누적
        time += (graph[top] * 2)
        # 최상단 층 갱신
        del graph[top]
    
print(time, max(graph.keys()), sep=" ")