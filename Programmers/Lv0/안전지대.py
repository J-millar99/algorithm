def solution(board):
    answer = 0
    row = len(board[0])
    col = len(board)
    for i in range(0, row):
        for j in range(0, col):
            if board[i][j] == 1:
                if i - 1 > -1 and board[i - 1][j] == 0:
                    board[i - 1][j] = 2
                if i + 1 < row and board[i + 1][j] == 0:
                    board[i + 1][j] = 2
                if j - 1 > -1 and board[i][j - 1] == 0:
                    board[i][j - 1] = 2
                if j + 1 < col and board[i][j + 1] == 0:
                    board[i][j + 1] = 2
                if i + 1 < row and j + 1 < col and board[i + 1][j + 1] == 0:
                    board[i + 1][j + 1] = 2
                if i - 1 > -1 and j + 1 < col and board[i - 1][j + 1] == 0:
                    board[i - 1][j + 1] = 2
                if i + 1 < row and j - 1 > -1 and board[i + 1][j - 1] == 0:
                    board[i + 1][j - 1] = 2
                if i - 1 > -1 and j - 1 > -1 and board[i - 1][j - 1] == 0:
                    board[i - 1][j - 1] = 2
    for i in range(0, row):
        for j in range(0, col):
            if board[i][j] == 0:
                answer += 1
    return answer