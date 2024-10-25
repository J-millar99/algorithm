n, m = map(int, input().split())
data = list(map(int, input().split()))

def cutting(s, e, order):
    mid = (s + e) // 2 # 절단기 높이
    total = 0 # 잘린 떡 길이의 총합
    for val in data:
        total += val - mid if val > mid else 0
    if total == order:
        return mid
    elif total > order: # 손님이 요구한 길이보다 많을 때
        return cutting(mid + 1, e, order)
    elif total < order: # 손님이 요구한 길이보다 부족할 때
        return cutting(s, mid - 1, order)

print(cutting(0, max(data), m))