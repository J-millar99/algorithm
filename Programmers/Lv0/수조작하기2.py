dic = {1 : "w", -1 : "s", 10 : "d", -10 : "a"}
def solution(numLog):
    answer = ""
    for i in range(1, len(numLog)):
        answer += dic[numLog[i] - numLog[i - 1]]
    return answer