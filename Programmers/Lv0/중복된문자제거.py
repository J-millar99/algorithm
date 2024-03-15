# set은 자동정렬되므로 정렬이 되지 않는 딕셔너리 구조를 이용
from collections import OrderedDict

def solution(my_string):
    my_set = list(OrderedDict.fromkeys(my_string))
    answer = ''.join(my_set)
    return answer