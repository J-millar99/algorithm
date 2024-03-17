def solution(arr, queries):
    answer = []
    for quri in queries:
        tmp = arr[quri[0]:quri[1] + 1]
        tmp.append(quri[2])
        if max(tmp) == quri[2]:
            answer.append(-1)
        else:
            tmp.sort()
            i = 0
            while tmp[tmp.index(quri[2]) + i] == quri[2]:
                i += 1
            answer.append(tmp[tmp.index(quri[2]) + i])
    return answer