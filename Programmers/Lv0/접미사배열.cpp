#include <string>
#include <vector>
#include <algorithm>
using namespace std;

vector<string> solution(string my_string) {
    vector<string> answer;
    for (int idx = 0; idx < my_string.length(); idx++)
        answer.push_back(my_string.substr(idx));
    sort(answer.begin(), answer.end());
    return answer;
}