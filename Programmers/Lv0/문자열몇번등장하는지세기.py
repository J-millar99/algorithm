def solution(myString, pat):
    answer = 0
    while True:
        index = myString.find(pat)
        if index == -1:
            break
        answer += 1
        myString = myString[index + 1:]
    return answer