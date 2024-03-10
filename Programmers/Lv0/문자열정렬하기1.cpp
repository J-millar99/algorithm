#include <string>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> solution(string my_string) {
    vector<int> answer;
    for (char ch : my_string)
        if (isdigit(ch))
            answer.push_back(static_cast<int>(ch - '0'));
    sort(answer.begin(), answer.end());
    return answer;
}