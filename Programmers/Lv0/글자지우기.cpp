#include <string>
#include <vector>
#include <algorithm>
using namespace std;

string solution(string my_string, vector<int> indices) {
    string answer = "";
    for (int idx = 0; idx < my_string.length(); idx++)
    {
        auto it = find(indices.begin(), indices.end(), idx);
        if (it == indices.end())
            answer += my_string[idx];
    }
    return answer;
}