

def solution(strArr):
    for idx in range(len(strArr)):
        if idx % 2 == 1:
            strArr[idx] = strArr[idx].upper()
        else :
            strArr[idx] = strArr[idx].lower()
    return strArr