def solution(spell, dic):
    # dic을 리스트화
    for str in dic:
        temp = list(str)
        if sorted(spell) == sorted(temp):
            return 1
    return 2