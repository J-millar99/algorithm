#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr, vector<vector<int>> intervals) {
    vector<int> answer;
    for (int idx = intervals[0][0]; idx <= intervals[0][1]; idx++)
        answer.push_back(arr[idx]);
    for (int idx = intervals[1][0]; idx <= intervals[1][1]; idx++)
        answer.push_back(arr[idx]);
    return answer;
}