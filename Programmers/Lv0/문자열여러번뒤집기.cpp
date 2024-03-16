#include <string>
#include <vector>
#include <algorithm>
using namespace std;

string solution(string my_string, vector<vector<int>> queries) {
    for (auto querie : queries)
    {
        string reStr = my_string.substr(querie[0], querie[1] - querie[0] + 1);
        reverse(reStr.begin(), reStr.end());
        my_string = my_string.substr(0, querie[0]) + reStr + my_string.substr(querie[1] + 1, my_string.length() - (querie[1] + 1));
    }
    return my_string;
}
// 문자열의 일부만 바꾸면 되는 것이었다
string solution(string my_string, vector<vector<int>> queries) {
    for (auto querie : queries)
        reverse(my_string.begin() + querie[0], my_string.begin() + querie[1] + 1);
    return my_string;
}