def solution(dots):
    inc = []
    for i in range(len(dots) - 1):
        for j in range(i + 1, len(dots)):
            if (dots[i][1] - dots[j][1] == 0 and dots[i][0] - dots[j][0] == 0):
                return 1
            if dots[j][0] - dots[i][0] == 0:
                inc.append((dots[i][1] - dots[j][1]) / (dots[i][0] - dots[j][0]))
            else:
                inc.append((dots[j][1] - dots[i][1]) / (dots[j][0] - dots[i][0]))
    for k in range(len(inc) // 2):
        if inc[k] == inc[len(inc) - k - 1]:
            return 1
    return 0