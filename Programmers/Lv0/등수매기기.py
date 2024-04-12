def solution(scores):
    score = [(score[0] + score[1]) / 2 for score in scores]
    i = 1
    rank = [0] * len(score)

    while (0 in rank): #모든 점수에 랭크를 매길때 까지
        adj = 0 # 등수 조정값
        if score.count(max(score)) == 1: # 최고점이 한 명이라면
            rank[score.index(max(score))] = i # 최고점의 인덱스에 매칭되는 rank 인덱스에 등수 표기
            score[score.index(max(score))] = -1 # 데이터를 삭제하면 인덱스가 변경되므로 최고점을 없애버림
            i += 1
        else: # 최고점이 여러명이면
            max_indexes = [index for index, value in enumerate(score) if value == max(score)]
            # 최고점의 인덱스를 모음
            for idx in max_indexes:
                rank[idx] = i # 등수 기록
                score[idx] = -1 # 최고점 없애기
                adj += 1 # 공동 등수 조정값
        i += adj
    return rank