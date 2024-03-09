#include <string>
#include <vector>

using namespace std;

string solution(vector<string> my_strings, vector<vector<int>> parts) {
    string answer = "";
    int idx = 0;
    for (string str : my_strings)
    {
        answer += str.substr((parts[idx])[0], (parts[idx])[1] - (parts[idx])[0] + 1);
        idx++;
    }
    return answer;
}