# 정렬을 통해 각 응급도에 따른 진료 순서를 딕셔너리 키, 값을 통해 배정한다.
# emergency배열의 값(응급도)에 해당하는 진료순서를 딕셔너리에서 뽑아 리스트에 넣는다.
def solution(emergency):
    answer = []
    dict = {}
    sort_emergency = sorted(emergency)
    for i in range(len(sort_emergency)):
        dict[sort_emergency[i]] = len(emergency) - i
    for i in emergency:
        answer.append(dict[i])
    return answer