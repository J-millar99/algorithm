def solution(order):
    cnt = 0
    order = str(order)
    for ch in order:
        if int(ch) % 3 == 0 and int(ch) != 0:
            cnt += 1
    return cnt