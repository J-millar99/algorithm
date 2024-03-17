def solution(num, total):
    answer = list(range(total - num + 1, total + 1))
    _sum = sum(answer)
    if _sum != total:
        answer = [x - ((_sum - total) / num) for x in answer]
    return answer