# 나무 자르기
n, target = map(int, input().split())
data = list(map(int, input().split()))

def cutting(s, e):
    while s <= e:
        mid = (s + e) // 2
        total = sum(val - mid if val > mid else 0 for val in data)
        if total >= target:
            ret = mid
            s = mid + 1
        else:
            e = mid - 1
    return ret

print(cutting(0, max(data)))