def solution(keyinput, board):
    answer = [0, 0]
    bound = [(board[0] // 2), board[1] // 2]
    for str in keyinput:
        if str == "up" and answer[1] < bound[1]:
            answer[1] += 1
        elif str == "down" and answer[1] > bound[1] * -1:
            answer[1] -= 1
        elif str == "left" and answer[0] > bound[0] * -1:
            answer[0] -= 1
        elif str == "right" and answer[0] < bound[0]:
            answer[0] += 1
    return answer