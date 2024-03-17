def solution(arrs):
    rowCnt = len(arrs) 
    colCnt = len(arrs[0])
    if rowCnt > colCnt:
        diff = rowCnt - colCnt
        for arr in arrs:
            for _ in range(diff):
                arr.append(0)
    elif rowCnt < colCnt:
        diff = colCnt - rowCnt
        for _ in range(diff):
            arrs.append([0] * colCnt)
    return arrs