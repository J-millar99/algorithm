#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr) {
    vector<int> answer;
    for (int iter : arr)
        for (size_t idx = 0; idx < iter; idx++)
            answer.push_back(iter);
    return answer;
}