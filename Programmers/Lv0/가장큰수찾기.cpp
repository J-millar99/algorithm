#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> array) {
    int max = 0, index = 0;
    for (size_t idx = 0; idx < array.size(); idx++) {
        if (max < array[idx])
        {
            max = array[idx];
            index = idx;
        }
    }
    vector<int> answer;
    answer.push_back(max);
    answer.push_back(index);
    return answer;
}