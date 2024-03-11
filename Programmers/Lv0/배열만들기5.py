def solution(intStrs, k, s, l):
    answer = []
    for str in intStrs:
        if int(str[s:s + l]) > k:
            answer.append(int(str[s:s + l]))
    return answer

# 리스트 컴프리헨션
def solution(intStrs, k, s, l):
    return [int(str[s:s + l]) for str in intStrs if int(str[s:s + l]) > k]