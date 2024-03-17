#include <string>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> solution(vector<int> arr, vector<vector<int>> queries) {
    vector<int> answer;
    for (vector<int> quri : queries) {
        vector<int> tmp(arr.begin() + quri[0], arr.begin() + quri[1] + 1);
        tmp.push_back(quri[2]);
        if (*max_element(tmp.begin(), tmp.end()) == quri[2])
            answer.push_back(-1);
        else {
            sort(tmp.begin(), tmp.end());
            int i = 0;
            while (*(find(tmp.begin(), tmp.end(), quri[2]) + i) == quri[2])
                ++i;
            answer.push_back(*(find(tmp.begin(), tmp.end(), quri[2]) + i));
        }
    }
    return answer;
}