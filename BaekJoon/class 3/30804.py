# 과일 탕후루
n = int(input())
data = list(map(int, input().split()))

def RightFirst():
    s = n // 2 - 1
    e = n // 2
    # 과일 종류 집합
    _set = set()
    _set.add(data[s])
    _set.add(data[e])
    flag = True
    while len(_set) <= 2 and e < n - 1:
        e += 1
        _set.add(data[e])
    if len(_set) == 3:
        e -= 1
        flag = False
        
    while len(_set) <= 2 and 0 < s:
        s -= 1
        _set.add(data[s])
    if len(_set) == 3 and flag:
        s += 1

    if len(_set) == 1:
        return e - s + 1
    return e - s + 1
        
def LeftFirst():
    s = n // 2 - 1
    e = n // 2
    # 과일 종류 집합
    _set = set()
    _set.add(data[s])
    _set.add(data[e])
    flag = True
    while len(_set) <= 2 and 0 < s:
        s -= 1
        _set.add(data[s])
    if len(_set) == 3:
        s += 1
        flag = False

    while len(_set) <= 2 and e < n - 1:
        e += 1
        _set.add(data[e])
    if len(_set) == 3 and flag:
        e -= 1

    if len(_set) == 1:
        return e - s + 1
    return e - s + 1

if n == 1:
    print(n)
else:
    print(max(RightFirst(), LeftFirst()))
