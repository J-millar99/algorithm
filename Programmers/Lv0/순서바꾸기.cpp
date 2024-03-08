#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> num_list, int n) {
    vector<int> answer;
    for (size_t idx = n; idx < num_list.size(); ++idx)
        answer.push_back(num_list[idx]);
    for (size_t idx = 0; idx < n; ++idx)
        answer.push_back(num_list[idx]);
    return answer;
}