def solution(num, k):
    num = str(num); k = str(k)
    for ch in num:
        if ch == k:
            return num.index(ch) + 1
    return -1