# 과일 탕후루
import sys
input = sys.stdin.readline

n = int(input())
fruit = list(map(int, input().split()))

def ConsistOf():
    # 투 포인터 선언
    left, right = 0, 0
    # 최대 과일 개수
    max_fruit = 0
    # 과일 등록
    fruit_dict = {}
    # rptr이 끝에 도달할 때까지
    while right < n:
        # 오른쪽으로 이동하면서 해당 과일이 사전에 있다면 개수 추가
        if fruit[right] in fruit_dict:
            fruit_dict[fruit[right]] += 1
        else:
            fruit_dict[fruit[right]] = 1
        # 과일 종류가 2개라면 left에 있는 반복되는 과일을 모두 제거
        while len(fruit_dict) > 2:
            fruit_dict[fruit[left]] -= 1
            if fruit_dict[fruit[left]] == 0:
                del fruit_dict[fruit[left]]
            left += 1
        max_fruit = max(max_fruit, right - left + 1)
        right += 1
    return (max_fruit)
print(ConsistOf())