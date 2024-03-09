#include <string>
#include <vector>

using namespace std;

vector<string> solution(vector<string> strArr) {
    vector<string> answer;
    for (string str : strArr)
        if (string::npos == str.find("ad"))
            answer.push_back(str);
    return answer;
}
