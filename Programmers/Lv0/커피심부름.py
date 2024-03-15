def solution(orders):
    answer = 0
    for order in orders:
        if "americano" in order or order == "anything":
            answer += 4500
        else:
            answer += 5000
    return answer