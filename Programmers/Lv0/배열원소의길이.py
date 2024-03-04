def solution(strlist):
    answer = []
    for _str in strlist:
        answer.append(len(_str))
    return answer

# for문을 간략하게 줄이는 방법
def solution(strlist):
    return [len(str) for str in strlist]

# list, map을 사용하는 방법
def solution(strlist):
    answer = list(map(len, strlist))
    return answer

'''
    map(len, strlist): map 함수는 두 인자를 받습니다.
    첫 번째 인자는 함수이며, 두 번째 인자는 iterable(반복 가능한 객체)입니다.
    여기서는 len 함수를 사용하여 문자열의 길이를 계산하는 함수를 적용하고, strlist의 각 원소에 대해 이 함수를 호출합니다.

    list(...): map의 결과를 리스트로 변환합니다.
    map 함수는 iterator를 반환하므로, 결과를 명시적으로 리스트로 변환하여 저장합니다.
'''