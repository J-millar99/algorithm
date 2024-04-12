#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<int>> board) {
    int answer = 0;
    int row = board[0].size();
    int col = board.size();
    for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
            if (board[i][j] == 1) {
                if (i - 1 > -1 && board[i - 1][j] == 0)
                    board[i - 1][j] = 2;
                if (i + 1 < row && board[i + 1][j] == 0)
                    board[i + 1][j] = 2;
                if (j - 1 > -1 && board[i][j - 1] == 0)
                    board[i][j - 1] = 2;
                if (j + 1 < col && board[i][j + 1] == 0)
                    board[i][j + 1] = 2;
                if (i + 1 < row && j + 1 < col && board[i + 1][j + 1] == 0)
                    board[i + 1][j + 1] = 2;
                if (i - 1 > -1 && j + 1 < col && board[i - 1][j + 1] == 0)
                    board[i - 1][j + 1] = 2;
                if (i + 1 < row && j - 1 > -1 && board[i + 1][j - 1] == 0)
                    board[i + 1][j - 1] = 2;
                if (i - 1 > -1 && j - 1 > -1 && board[i - 1][j - 1] == 0)
                    board[i - 1][j - 1] = 2;
            }
        }
    }
    for (int i = 0; i < row; i++)
        for (int j = 0; j < col; j++)
            if (board[i][j] == 0)
                answer += 1;
    return answer;
}