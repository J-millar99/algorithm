from collections import Counter

def solution(strArr):
    lenArr = []
    for str in strArr:
        lenArr.append(len(str))
    counts = Counter(lenArr)
    most_common_element, count = counts.most_common(1)[0]
    return count

# 매핑방법
def solution(strArr):
    data = [0] * 31
    for x in strArr:
        data[len(x)] += 1
    return max(data)