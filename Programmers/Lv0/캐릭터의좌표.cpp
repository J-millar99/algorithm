#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<string> keyinput, vector<int> board) {
    vector<int> answer(2, 0);
    for (string str : keyinput) {
        if (str == "up" and answer[1] < board[1] / 2)
            answer[1] += 1;
        else if (str == "down" and answer[1] > board[1] / 2 * -1)
            answer[1] -= 1;
        else if (str == "left" and answer[0] > board[0] / 2 * -1)
            answer[0] -= 1;
        else if (str == "right" and answer[0] < board[0] / 2)
            answer[0] += 1;
    }
    return answer;
}