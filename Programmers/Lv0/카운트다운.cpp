#include <string>
#include <vector>

using namespace std;

vector<int> solution(int start, int end_num) {
    vector<int> answer;
    for (int idx = start; idx >= end_num; idx--)
        answer.push_back(idx);
    return answer;
}