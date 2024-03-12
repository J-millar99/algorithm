#include <string>
#include <vector>

using namespace std;

vector<vector<int>> solution(vector<int> num_list, int n) {
    vector<vector<int>> answers;
    for (int idx = 0; idx < num_list.size() / n; idx++)
    {
        vector<int> answer;
        for (int jdx = idx * n; jdx < idx * n + n; jdx++)
            answer.push_back(num_list[jdx]);
        answers.push_back(answer);
    }
    return answers;
}