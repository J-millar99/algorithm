#include <string>
#include <vector>

using namespace std;

string solution(vector<string> str_list, string ex) {
    string answer = "";
    for (string str : str_list)
        if (string::npos == str.find(ex))
            answer += str;
    return answer;
}