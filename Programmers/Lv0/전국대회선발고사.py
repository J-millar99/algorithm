def solution(rank, attendance):
    dic = {}
    i = 0
    for r in rank:
        if attendance[i] == True:
            dic[r] = i
        i += 1
    tmp = sorted(list(dic.keys()))
    return 10000 * dic[tmp[0]] + 100 * dic[tmp[1]] + dic[tmp[2]]